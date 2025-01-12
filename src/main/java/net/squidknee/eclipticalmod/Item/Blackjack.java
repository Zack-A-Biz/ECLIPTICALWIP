package net.squidknee.eclipticalmod.Item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;

public class Blackjack extends Item {

    private static final int COOLDOWN_TICKS = 20;

    public Blackjack(Settings settings) {
        super(settings);
    }

    // Example: Drawing a card and saving it into the custom NBT component
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Retrieve existing custom NBT data from the item
        NbtComponent customData = itemStack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);

        // Get or create NbtCompound from the NbtComponent
        NbtCompound nbt = customData.copyNbt();

        // Initialize deck if not present
        if (!nbt.contains("cardsLeft")) {
            addCardsToNBT(nbt); // Custom method to initialize the deck
        }

        // Retrieve the last used time from NBT
        long lastUsed = nbt.getLong("lastUsed");
        long currentTime = world.getTime();

        if (currentTime - lastUsed < COOLDOWN_TICKS) {
            user.sendMessage(Text.literal("This item is still on cooldown!"), false);
            return TypedActionResult.fail(itemStack); // Fail if cooldown has not elapsed
        }

        // Check if there are cards left in the deck
        if (cardsLeft(nbt) > 0) {
            String card = drawCard(nbt); // Draw a card from the deck
            user.sendMessage(Text.literal("You drew: " + card), false);
            user.sendMessage(Text.literal("Cards left in deck: " + cardsLeft(nbt)), false);

            // Save the updated NBT back to the item
            itemStack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt)); // Save the modified NBT to the item
            nbt.putLong("lastUsed", currentTime);
            return TypedActionResult.success(itemStack); // Indicate successful use
        } else {
            user.sendMessage(Text.literal("No cards left in the deck!"), false);
            return TypedActionResult.fail(itemStack); // Indicate failure because the deck is empty
        }
    }

    // Method to use on blocks (Right-click interaction with blocks)
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            outputCardValue(context.getPlayer());
        }
        return ActionResult.SUCCESS;
    }

    // Output the card value and number of cards left in the deck
    private void outputCardValue(PlayerEntity player) {
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);

        // Get custom NBT data
        NbtComponent customData = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
        NbtCompound nbt = customData.copyNbt();

        if (nbt != null) {
            String card = drawCard(nbt);
            player.sendMessage(Text.literal(card), false);
            player.sendMessage(Text.literal("Cards left in deck: " + cardsLeft(nbt)), false);
        }
    }

    // Initialize the deck of cards in the NBT
    private void addCardsToNBT(NbtCompound nbt) {
        ArrayList<String> cardsLeft = createDeck();
        NbtList cardsLeftList = new NbtList();

        for (String card : cardsLeft) {
            cardsLeftList.add(NbtString.of(card));
        }

        // Store the NbtList in the NbtCompound
        nbt.put("cardsLeft", cardsLeftList);
    }

    // Create a shuffled deck of cards
    private ArrayList<String> createDeck() {
        ArrayList<String> cards = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        for (String suit : suits) {
            for (int j = 0; j < 13; j++) {
                String num;
                if (j == 0) {
                    num = "A"; // Ace
                } else if (j <= 10) {
                    num = Integer.toString(j + 1); // 2-10
                } else {
                    String[] faceCards = {"Jack", "Queen", "King"};
                    num = faceCards[j - 11]; // J, Q, K
                }
                cards.add(num + " of " + suit);
            }
        }
        Collections.shuffle(cards); // Shuffle the deck
        return cards;
    }

    // Method to draw a card from the deck
    public String drawCard(NbtCompound nbt) {
        NbtList cardsLeftList = nbt.getList("cardsLeft", 8); // Get the list of cards
        if (cardsLeftList.isEmpty()) {
            return "No cards left in the deck!";
        }

        // Draw the last card from the deck
        String drawnCard = cardsLeftList.remove(cardsLeftList.size() - 1).asString();
        nbt.put("cardsLeft", cardsLeftList); // Update the NBT with the remaining cards

        // Update drawn cards count
        int cardsDrawn = nbt.getInt("cardsDrawn");
        nbt.putInt("cardsDrawn", cardsDrawn + 1);

        return drawnCard;
    }

    // Get the number of cards left in the deck
    public int cardsLeft(NbtCompound nbt) {
        NbtList cardsLeftList = nbt.getList("cardsLeft", 8);
        return cardsLeftList.size();
    }
}

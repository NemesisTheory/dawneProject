package DawneProject.content;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;

public class DawneBlocks {
    public static Block

            //distribution - Dawne

            ErumConveyor, ErumJunction, ErumBridge, ErumRouter, ErumOverflow, ErumUnderflow, ErumSorter;

    public static void load() {
        ErumConveyor = new Conveyor("erum-conveyor"){{
            requirements(Category.distribution, with(DawneItems.erum, 1));
            health = 5;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            researchCost = with(Items.scrap, 5);
            junctionReplacement = ErumJunction;
            bridgeReplacement = ErumBridge;
        }};

        ErumJunction = new Junction("erum-junction"){{
            requirements(Category.distribution, with(Items.scrap, 2));
            health = 5;
            speed = 12f;
            capacity = 1;
            buildCostMultiplier = 3f;
        }};

        ErumBridge = new BufferedItemBridge("erum-bridge"){{
            requirements(Category.distribution, with(DawneItems.erum, 4, DawneItems.caris, 2));
            health = 5;
            range = 4;
            arrowSpacing = 5f;
            speed = 12f;
            bufferCapacity = 3;
        }};

        ErumRouter = new Router("erum-router"){{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 5;
            buildCostMultiplier = 2f;
        }};

        ErumOverflow = new OverflowGate("erum-overflow"){{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};

        ErumUnderflow = new OverflowGate("erum-underflow"){{
            requirements(Category.distribution, with (DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
            invert = true;
        }};

        ErumSorter = new Sorter("erum-sorter"){{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};
    }
}
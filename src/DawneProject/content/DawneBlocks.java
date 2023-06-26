package DawneProject.content;

import arc.graphics.Color;
import mindustry.entities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import mindustry.content.Items;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.production.GenericCrafter;

import static mindustry.type.ItemStack.with;

public class DawneBlocks {
    public static Block

            //distribution - Dawne

            ErumConveyor, ErumJunction, ErumBridge, ErumRouter, ErumOverflow, ErumUnderflow, ErumSorter, ErumInvertedSorter,

    //production - Dawne

    CarisPress,

    //pewpews - Dawne

    Fracture, Broadside;

    public static void load() {
        ErumConveyor = new Conveyor("erum-conveyor") {{
            requirements(Category.distribution, with(DawneItems.erum, 1));
            health = 5;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            researchCost = with(Items.scrap, 5);
            junctionReplacement = ErumJunction;
            bridgeReplacement = ErumBridge;
        }};

        ErumJunction = new Junction("erum-junction") {{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 5;
            speed = 12f;
            capacity = 1;
            buildCostMultiplier = 3f;
        }};

        ErumBridge = new BufferedItemBridge("erum-bridge") {{
            requirements(Category.distribution, with(DawneItems.erum, 4, DawneItems.caris, 2));
            health = 5;
            range = 3;
            arrowSpacing = 5f;
            speed = 12f;
            bufferCapacity = 3;
        }};

        ErumRouter = new Router("erum-router") {{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 5;
            buildCostMultiplier = 2f;
        }};

        ErumOverflow = new OverflowGate("erum-overflow") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};

        ErumUnderflow = new OverflowGate("erum-underflow") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
            invert = true;
        }};

        ErumSorter = new Sorter("erum-sorter") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};

        ErumInvertedSorter = new Sorter("erum-inverted-sorter") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
            invert = true;
        }};

        CarisPress = new GenericCrafter("caris-press") {{
            requirements(Category.production, with(DawneItems.erum, 70));
            outputItem = new ItemStack(DawneItems.caris, 2);
            craftEffect = Fx.smeltsmoke;
            craftTime = 138f;
            size = 3;
            hasItems = true;
        }};

        Fracture = new ItemTurret("fracture") {
            {
                requirements(Category.turret, with(DawneItems.erum, 40, DawneItems.caris, 15));
                Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                health = 50;
                recoil = 3f;
                reload = 40f;
                range = 110;
                shootCone = 1f;
                inaccuracy = 0.5f;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 3f;
                shake = 2f;
                ammoPerShot = 2;
                shootY = -1;
                size = 3;
                rotateSpeed = 1.5f;
                researchCostMultiplier = 0.05f;
                ammo(
                        DawneItems.verent, new BasicBulletType(8f, 10) {{
                            width = 12f;
                            hitSize = 7f;
                            height = 20f;
                            shootEffect = sfe;
                            smokeEffect = Fx.shootBigSmoke;
                            ammoMultiplier = 1;
                            pierceCap = 4;
                            pierce = true;
                            pierceBuilding = true;
                            hitColor = backColor = trailColor = Color.valueOf("c48282");
                            frontColor = Color.white;
                            trailWidth = 2.1f;
                            trailLength = 10;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            buildingDamageMultiplier = 0.5f;
                        }},
                        DawneItems.caris, new BasicBulletType(9f, 25) {
                            {
                                splashDamage = 4;
                                splashDamageRadius = 12.4f;
                                width = 12f;
                                hitSize = 7f;
                                height = 20f;
                                shootEffect = sfe;
                                smokeEffect = Fx.shootBigSmoke;
                                ammoMultiplier = 2;
                                pierceCap = 2;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = Color.valueOf("8a83eb");
                                frontColor = Color.white;
                                reloadMultiplier = 1.35f;
                                trailWidth = 2.1f;
                                trailLength = 10;
                                hitEffect = despawnEffect = Fx.hitBulletColor;
                                buildingDamageMultiplier = 0.5f;
                            }
                        }
                );
            }
        };
    }
}
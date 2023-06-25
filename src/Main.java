import java.util.Random;

// Герой Witcher
class Witcher extends Hero {
    private boolean revived;

    public Witcher(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.revived = false;
    }

    public void reviveHero(Hero hero) {
        if (!revived) {
            hero.setHealth(1);
            hero.setDamage(0);
            this.setHealth(0);
            this.revived = true;
            System.out.println("Witcher оживил героя: " + hero.getClass().getSimpleName());
        }
    }

   
    public void applySuperAbility() {
        System.out.println("Witcher применил суперспособность: " + getSuperAbility());
    }
}

// Герой Thor
class Thor extends Hero {
    private boolean stunned;

    public Thor(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.stunned = false;
    }

    public void stunBoss() {
        if (!stunned) {
            stunned = true;
            System.out.println("Thor оглушил босса на 1 раунд");
        }
    }


    public void applySuperAbility() {
        System.out.println("Thor применил суперспособность: " + getSuperAbility());
    }
}

// Герой Golem
class Golem extends Hero {
    public Golem(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void absorbDamage(int damage) {
        int absorbedDamage = damage / 5;
        setHealth(getHealth() - absorbedDamage);
        System.out.println("Golem поглотил " + absorbedDamage + " единиц урона");
    }


    public void applySuperAbility() {
        System.out.println("Golem применил суперспособность: " + getSuperAbility());
    }
}

// Героиня Avrora
class Avrora extends Hero {
    private boolean invisible;
    private boolean usedInvisibility;

    public Avrora(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.invisible = false;
        this.usedInvisibility = false;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public boolean isUsedInvisibility() {
        return usedInvisibility;
    }

    public void useInvisibility() {
        if (!usedInvisibility) {
            invisible = true;
            usedInvisibility = true;
            System.out.println("Avrora вошла в режим невидимости");
        }
    }


    public void applySuperAbility() {
        System.out.println("Avrora применила суперспособность: " + getSuperAbility());
    }
}

// Герой Друид
class Druid extends Hero {
    private boolean summonUsed;
    private boolean angelSummoned;
    private boolean crowSummoned;
    private int healBoost;

    public Druid(int health, int damage, String superAbility, int healBoost) {
        super(health, damage, superAbility);
        this.summonUsed = false;
        this.angelSummoned = false;
        this.crowSummoned = false;
        this.healBoost = healBoost;
    }

    public void summonCreature(Boss boss) {
        if (!summonUsed) {
            Random random = new Random();
            int summon = random.nextInt(2);
            if (summon == 0) {
                boss.setAggression(boss.getAggression() + healBoost);
                angelSummoned = true;
                System.out.println("Друид призвал помощника ангела");
            } else {
                boss.setAggression(boss.getAggression() * 1.5);
                crowSummoned = true;
                System.out.println("Друид призвал помощника ворону");
            }
            summonUsed = true;
        }
    }


    public void applySuperAbility() {
        System.out.println("Друид применил суперспособность: " + getSuperAbility());
    }
}

// Герой Hacker
class Hacker extends Hero {
    private int stolenHealth;

    public Hacker(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.stolenHealth = 0;
    }

    public void hackBoss(Boss boss) {
        int stolen = boss.getHealth() / 3;
        boss.setHealth(boss.getHealth() - stolen);
        setHealth(getHealth() + stolen);
        stolenHealth += stolen;
        System.out.println("Hacker забрал " + stolen + " единиц здоровья у босса");
    }


    public void applySuperAbility() {
        System.out.println("Hacker применил суперспособность: " + getSuperAbility());
    }
}

// Герой TrickyBastard
class TrickyBastard extends Hero {
    private boolean playingDead;
    private int deadRound;

    public TrickyBastard(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.playingDead = false;
        this.deadRound = -1;
    }

    public void playDead() {
        if (!playingDead) {
            Random random = new Random();
            deadRound = random.nextInt(3) + 1;
            playingDead = true;
            System.out.println("TrickyBastard притворился мертвым в раунде " + deadRound);
        }
    }

    public void resetDeadStatus() {
        playingDead = false;
        deadRound = -1;
    }

    public boolean isPlayingDead() {
        return playingDead;
    }

    public int getDeadRound() {
        return deadRound;
    }


    public void applySuperAbility() {
        System.out.println("TrickyBastard применил суперспособность: " + getSuperAbility());
    }
}

// Герой Antman
class Antman extends Hero {
    private boolean enlarged;

    public Antman(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.enlarged = false;
    }

    public void changeSize() {
        enlarged = !enlarged;
        if (enlarged) {
            setHealth(getHealth() * 2);
            setDamage(getDamage() * 2);
            System.out.println("Antman увеличился");
        } else {
            setHealth(getHealth() / 2);
            setDamage(getDamage() / 2);
            System.out.println("Antman уменьшился");
        }
    }


    public void applySuperAbility() {
        System.out.println("Antman применил суперспособность: " + getSuperAbility());
    }
}

// Герой Deku
class Deku extends Hero {
    private int power;
    private int hpLoss;

    public Deku(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
        this.power = 1;
        this.hpLoss = 0;
    }

    public void increasePower() {
        Random random = new Random();
        int powerIncrease = random.nextInt(3) + 1;
        power += powerIncrease;
        hpLoss = (int) (getHealth() * (0.2 * powerIncrease));
        setHealth(getHealth() - hpLoss);
        System.out.println("Deku усилил свою силу на " + (powerIncrease * 20) + "%, но потерял " + hpLoss + " единиц здоровья");
    }

    public int getPower() {
        return power;
    }


    public void applySuperAbility() {
        System.out.println("Deku применил суперспособность: " + getSuperAbility());
    }
}

// Герой Kamikadze
class Kamikadze extends Hero {
    public Kamikadze(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void sacrifice() {
        setHealth(0);
        System.out.println("Kamikadze пожертвовал собой");
    }


    public void applySuperAbility() {
        System.out.println("Kamikadze применил суперспособность: " + getSuperAbility());
    }
}

// Герой Samurai
class Samurai extends Hero {
    public Samurai(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void throwShuriken(Boss boss) {
        Random random = new Random();
        int shurikenType = random.nextInt(2);
        if (shurikenType == 0) {
            int damage = random.nextInt(50) + 1;
            boss.setHealth(boss.getHealth() - damage);
            System.out.println("Samurai кинул вирусный сюрикен и нанес боссу " + damage + " единиц урона");
        } else {
            int heal = random.nextInt(50) + 1;
            boss.setHealth(boss.getHealth() + heal);
            System.out.println("Samurai кинул вакцину и восстановил боссу " + heal + " единиц здоровья");
        }
    }


    public void applySuperAbility() {
        System.out.println("Samurai применил суперспособность: " + getSuperAbility());
    }
}

// Герой Bomber
class Bomber extends Hero {
    public Bomber(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void explode(Boss boss) {
        boss.setHealth(boss.getHealth() - 100);
        System.out.println("Bomber взорвался и нанес боссу 100 единиц урона");
        setHealth(0);
    }


    public void applySuperAbility() {
        System.out.println("Bomber применил суперспособность: " + getSuperAbility());
    }
}

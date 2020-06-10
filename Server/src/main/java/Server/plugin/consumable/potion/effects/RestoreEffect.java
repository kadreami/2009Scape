package plugin.consumable.potion.effects;

import core.game.node.entity.player.Player;
import plugin.consumable.potion.PotionEffect;
import plugin.skill.Skills;

public class RestoreEffect extends PotionEffect {
    double base,bonus;
    public RestoreEffect(double base, double bonus){
        this.base = base;
        this.bonus = bonus;
    }
    final int[] SKILLS = new int[] { Skills.DEFENCE, Skills.ATTACK, Skills.STRENGTH, Skills.MAGIC, Skills.RANGE };
    @Override
    public void activate(Player p) {
        Skills sk = p.getSkills();
        for(int skill : SKILLS){
            int statL = sk.getStaticLevel(skill);
            int curL = sk.getLevel(skill);
            if(curL < statL){
                int boost = (int) (base + (statL * bonus));
                p.getSkills().updateLevel(skill, boost, statL);
            }
        }
    }
}

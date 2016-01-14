package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * This object contains item data. Almost exactly the
 * same as {@link BasicDataDto}.<br/>
 * <a href="https://developer.riotgames.com/discussion/announcements/show/6OqJwp1E">Inheritance
 * Discussion</a>
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ItemDto extends BasicDataDto {
    private Map<String, String> effect;

    public Map<String, String> getEffect() {
        return effect;
    }

    public void setEffect(Map<String, String> effect) {
        this.effect = effect;
    }
}

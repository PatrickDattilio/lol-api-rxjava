package org.dc.riot.lol.rx.model.staticdata;

import java.util.List;

import org.dc.riot.lol.rx.model.BlockItemDto;

/**
 * This object contains champion recommended block data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BlockDto {
    private List<BlockItemDto> items;
    private boolean recMath;
    private String type;

    public List<BlockItemDto> getItems() {
        return items;
    }

    public void setItems(List<BlockItemDto> items) {
        this.items = items;
    }

    public boolean isRecMath() {
        return recMath;
    }

    public void setRecMath(boolean recMath) {
        this.recMath = recMath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

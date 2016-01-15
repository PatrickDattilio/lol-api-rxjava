package org.dc.riot.lol.rx.service.request;

/**
 * {@link org.dc.riot.lol.rx.service.RiotApi.StaticData RiotApi.StaticData} parameter
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum SpellDataTag {
    ALL,
    COOLDOWN,
    COOLDOWN_BURN {
        @Override
        public String toString() {
            return "cooldownBurn";
        }
    },
    COST,
    COST_BURN {
        @Override
        public String toString() {
            return "costBurn";
        }
    },
    COST_TYPE {
        @Override
        public String toString() {
            return "costType";
        }
    },
    EFFECT,
    EFFECT_BURN {
        @Override
        public String toString() {
            return "effectBurn";
        }
    },
    IMAGE,
    KEY,
    LEVELTIP,
    MAXRANK,
    MODES,
    RANGE,
    RANGE_BURN {
        @Override
        public String toString() {
            return "rangeBurn";
        }
    },
    RESOURCE,
    SANITIZED_DESCRIPTION {
        @Override
        public String toString() {
            return "sanitizedDescription";
        }
    },
    SANITIZEDTOOLTIP,
    TOOLTIP,
    VARS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


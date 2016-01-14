package org.dc.riot.lol.rx.service.request;


/**
 * {@link org.dc.riotapi.service.RiotApi.StaticData} request parameter
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum RuneListDataTag {
    ALL,
    BASIC,
    COLLOQ,
    CONSUME_ON_FULL {
        @Override
        public String toString() {
            return "consumeOnFull";
        }
    },
    CONSUMED,
    DEPTH,
    FROM,
    GOLD,
    HIDE_FROM_ALL {
        @Override
        public String toString() {
            return "hideFromAll";
        }
    },
    IMAGE,
    IN_STORE {
        @Override
        public String toString() {
            return "inStore";
        }
    },
    INTO,
    MAPS,
    REQUIRED_CHAMPION {
        @Override
        public String toString() {
            return "requiredChampion";
        }
    },
    SANITIZED_DESCRIPTION {
        @Override
        public String toString() {
            return "sanitizedDescription";
        }
    },
    SPECIAL_RECIPE {
        @Override
        public String toString() {
            return "specialRecipe";
        }
    },
    STACKS,
    STATS,
    TAGS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


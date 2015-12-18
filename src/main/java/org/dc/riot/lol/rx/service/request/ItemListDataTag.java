package org.dc.riot.lol.rx.service.request;

/**
 * Used by {@link org.dc.riotapi.service.RiotApi.StaticData}
 * Created by Dc on 10/20/15.
 */
public enum ItemListDataTag {
    ALL,
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
    GROUPS,
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
            return "requiredDescription";
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
    TAGS,
    TREE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


package org.dc.riot.lol.rx.service.request;

/**
 * Used by {@link org.dc.riotapi.service.RiotApi.StaticData}
 * @author Dc
 * @since 1.0.0
 */
public enum MasteryListDataTag {
    ALL,
    IMAGE,
    MASTERY_TREE {
        @Override
        public String toString() {
            return "masteryTree";
        }
    },
    PREREQ,
    RANKS,
    SANITIZED_DESCRIPTION {
        @Override
        public String toString() {
            return "sanitizedDescription";
        }
    },
    TREE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


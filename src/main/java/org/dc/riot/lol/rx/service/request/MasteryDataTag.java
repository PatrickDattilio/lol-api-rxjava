package org.dc.riot.lol.rx.service.request;

/**
 * Used by {@link org.dc.riotapi.service.RiotApi.StaticData}
 * Created by Dc on 10/20/15.
 */
public enum MasteryDataTag {
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
    };

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


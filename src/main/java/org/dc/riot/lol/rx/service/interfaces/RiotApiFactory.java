package org.dc.riot.lol.rx.service.interfaces;

import java.lang.reflect.Type;
import java.net.Proxy;

import org.dc.riot.lol.rx.model.RangeDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.InvalidVersionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.squareup.okhttp.OkHttpClient;

import rx.Scheduler;

/**
 * Use this class to generate instances of {@link RiotApi} interfaces. Use the associated {@link Builder}
 * to call into specific versions if needed.
 * Created by Dc on 9/30/15.
 */
public final class RiotApiFactory {

    private static Gson GSON = null;
    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(RangeDto.class, new JsonDeserializer<RangeDto>() {
            @Override
            public RangeDto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                String rString = json.toString().replace("\"", ""); // sometimes the JsonElement has superfluous quotes in it
                int[] ranges = null;
                if (!"self".equalsIgnoreCase(rString)) {
                    JsonArray jRanges = json.getAsJsonArray();
                    int index = 0;
                    ranges = new int[jRanges.size()];
                    for (JsonElement o : jRanges) {
                        ranges[index] = o.getAsInt();
                        index++;
                    }
                }

                return new RangeDto(ranges);
            }
        });

        GSON = builder.create();
    }

    public static RiotApiFactory getDefaultFactory() {
        return new Builder().build();
    }
    
    private final OkHttpClient client;
    private Scheduler scheduler = null;

    private float champVersion;
    private float currentGameVersion;
    private float featuredGamesVersion;
    private float recentGamesVersion;
    private float leagueVersion;
    private float staticDataVersion;
    private float statsVersion;
    private float statusVersion;
    private float matchVersion;
    private float matchlistVersion;
    private float summonerVersion;
    private float teamVersion;
    
    public static Gson getGson() {
    	return GSON;
    }

    private RiotApiFactory() {
    	client = new OkHttpClient();
    }

    public RiotApi.Champion newChampionInterface(ApiKey apiKey, Region region) {
        if (champVersion >= 1.2) {
            return new Champion_v1_2(apiKey, region, client);
        } else {
            throw new InvalidVersionException("Lowest supported Champion version is 1.2");
        }
    }

//    public RiotApi.CurrentGame newCurrentGameInterface(String apiKey) {
//        if (currentGameVersion >= 1.0f) {
//            return new ImplCurrentGame_v1_0(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported CurrentGame version is 1.0");
//        }
//    }
//
//    public RiotApi.FeaturedGames newFeaturedGamesInterface(String apiKey) {
//        if (featuredGamesVersion >= 1.0f) {
//            return new ImplFeaturedGames_v1_0(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported FeaturedGames version is 1.0");
//        }
//    }

    public RiotApi.RecentGames newRecentGamesInterface(ApiKey apiKey, Region region) {
        if (recentGamesVersion >= 1.3f) {
            return new RecentGames_v1_3(apiKey, region, client);
        } else {
            throw new InvalidVersionException("Lowest supported RecentGames version is 1.3");
        }
    }

//    public RiotApi.League newLeagueInterface(String apiKey) {
//        if (leagueVersion >= 2.5) {
//            return new ImplLeague_v2_5(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported League version is 2.5");
//        }
//    }
//
//    public RiotApi.StaticData newStaticDataInterface(String apiKey) {
//        if (staticDataVersion >= 1.2) {
//            return new ImplStaticData_v1_2(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported StaticData version is 1.2");
//        }
//    }

    public RiotApi.Stats newStatsInterface(ApiKey apiKey, Region region) {
    	if (statsVersion >= 1.3) {
    		return new Stats_v1_3(apiKey, region, client);
    	} else {
    		throw new InvalidVersionException("Lowest supported StaticData version is 1.2");
    	}
    }

//    public RiotApi.LolStatus newStatusInterface(String apiKey) {
//        if (statusVersion >= 1.0f) {
//            return new ImplLolStatus_v1_0(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported LolStatus version is 1.0");
//        }
//    }
//
//    public RiotApi.Match newMatchInterface(String apiKey) {
//        if (matchVersion >= 2.2f) {
//            return new ImplMatch_v2_2(apiKey);
//        } else {
//            throw new InvalidVersionException("Lowest supported Match version is 2.2");
//        }
//    }

    public RiotApi.MatchList newMatchListInterface(ApiKey apiKey, Region region) {
        if (matchlistVersion >= 2.2) {
            return new MatchList_v2_2(apiKey, region, client);
        } else {
            throw new InvalidVersionException("Lowest supported MatchListDto version is 2.2");
        }
    }

    public RiotApi.Summoner newSummonerInterface(ApiKey apiKey, Region region) {
        if (summonerVersion >= 1.4f) {
        	return new Summoner_v1_4(apiKey, region, client);
        } else {
            throw new InvalidVersionException("Lowest supported Summoner version is 1.4");
        }
    }

    public RiotApi.Team newTeamInterface(ApiKey apiKey, Region region) {
        if (teamVersion >= 2.4f) {
            return new Team_v2_4(apiKey, region, client);
        } else {
            throw new InvalidVersionException("Lowest supported Team version is 2.4");
        }
    }

    /**
     * Used to create {@link RiotApiFactory} instances pointed at specific versions.
     */
    public static class Builder {
        private float champVersion = 1.2f;          // baseline Champion version
        private float currentGameVersion = 1.0f;    // baseline CurrentGame version
        private float featuredGamesVersion = 1.0f;  // baseline FeaturedGame version
        private float recentGamesVersion = 1.3f;    // baseline FeaturedGame version
        private float leagueVersion = 2.5f;         // baseline League version
        private float statsVersion = 1.3f;			// baseline Stats version
        private float staticDataVersion = 1.2f;     // baseline StaticData version
        private float statusVersion = 1.0f;         // baseline LolStatus version
        private float matchVersion = 2.2f;          // baseline Match version
        private float matchlistVersion = 2.2f;      // baseline MatchListDto version
        private float summonerVersion = 1.4f;       // baseline Summoner version
        private float teamVersion = 2.4f;           // baseline Team version
        private Proxy proxy = null;
        private Scheduler scheduler = null;

        public Builder setChampionVersion(float champVersion) {
            this.champVersion = champVersion;
            return this;
        }

        public Builder setCurrentGameVersion(float currentGameVersion) {
            this.currentGameVersion = currentGameVersion;
            return this;
        }

        public Builder setFeaturedGamesVersion(float featuredGamesVersion) {
            this.featuredGamesVersion = featuredGamesVersion;
            return this;
        }

        public Builder setRecentGamesVersion(float recentGamesVersion) {
            this.recentGamesVersion = recentGamesVersion;
            return this;
        }

        public Builder setLeagueVersion(float leagueVersion) {
            this.leagueVersion = leagueVersion;
            return this;
        }

        public Builder setStaticDataVersion(float staticDataVersion) {
            this.staticDataVersion = staticDataVersion;
            return this;
        }
        
        public Builder setStatsVersion(float statsVersion) {
        	this.statsVersion = statsVersion;
        	return this;
        }

        public Builder setStatusVersion(float statusVersion) {
            this.statusVersion = statusVersion;
            return this;
        }

        public Builder setMatchVersion(float matchVersion) {
            this.matchVersion = matchVersion;
            return this;
        }

        public Builder setMatchListVersion(float matchlistVersion) {
            this.matchlistVersion = matchlistVersion;
            return this;
        }

        public Builder setSummonerVersion(float summonerVersion) {
            this.summonerVersion = summonerVersion;
            return this;
        }

        public Builder setTeamVersion(float teamVersion) {
            this.teamVersion = teamVersion;
            return this;
        }
        
        public Builder setProxy(Proxy proxy) {
        	this.proxy = proxy;
        	return this;
        }
        
        public Builder setScheduler(Scheduler scheduler) {
        	this.scheduler = scheduler;
        	return this;
        }

        public RiotApiFactory build() {
            RiotApiFactory factory = new RiotApiFactory();
            factory.champVersion = champVersion;
            factory.currentGameVersion = currentGameVersion;
            factory.featuredGamesVersion = featuredGamesVersion;
            factory.recentGamesVersion = recentGamesVersion;
            factory.leagueVersion = leagueVersion;
            factory.staticDataVersion = staticDataVersion;
            factory.statsVersion = statsVersion;
            factory.statusVersion = statusVersion;
            factory.matchVersion = matchVersion;
            factory.matchlistVersion = matchlistVersion;
            factory.summonerVersion = summonerVersion;
            factory.teamVersion = teamVersion;
            factory.client.setProxy(proxy);
            factory.scheduler = scheduler;
            return factory;
        }
    }
}

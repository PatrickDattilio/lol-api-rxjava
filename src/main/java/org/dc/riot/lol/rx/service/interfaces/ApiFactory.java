package org.dc.riot.lol.rx.service.interfaces;

import java.lang.reflect.Type;
import java.net.Proxy;

import org.dc.riot.lol.rx.model.RangeDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApi.RateType;
import org.dc.riot.lol.rx.service.error.InvalidVersionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Use this class to generate instances of {@link RiotApi} interfaces. Use the associated {@link Builder}
 * to call into specific versions if needed.
 * @author Dc
 * @since 1.0
 */
public final class ApiFactory {

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
    
    public static Gson getGson() {
    	return GSON;
    }

    /**
     * Basic entry point to fetching Riot's LoL API data. This method creates a factory that
     * will return interface calls for all recent versions of the LoL API.
     * 
     * @param apiKey API key that this factory will use to create interface connections
     * @return a {@link ApiFactory} for the given API key to access all newest
     * LoL API versions
     */
    public static ApiFactory newDefaultFactory(ApiKey apiKey) {
        return new Builder(apiKey).build();
    }
    
    /*
     * API versions
     */
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
    
    /*
     * Operating behind HTTP proxies
     */
    private Proxy proxy;
    
    private final ApiKey apiKey;

    private ApiFactory(ApiKey apiKey) {
    	this.apiKey = apiKey;
    }

    public RiotApi.Champion newChampionInterface(Region region, boolean autoRateControl) {
		RiotApi.Champion api = null;

        if (champVersion >= 1.2) {
            api = new Champion_v1_2(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported Champion version is 1.2");
        }

		completeBuild(RiotApi.Champion.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.CurrentGame newCurrentGameInterface(Region region, boolean autoRateControl) {
		RiotApi.CurrentGame api = null;

        if (currentGameVersion >= 1.0f) {
            api = new CurrentGame_v1_0(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported CurrentGame version is 1.0");
        }

		completeBuild(RiotApi.CurrentGame.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.FeaturedGames newFeaturedGamesInterface(Region region, boolean autoRateControl) {
    	RiotApi.FeaturedGames api = null;
    	
        if (featuredGamesVersion >= 1.0f) {
            api = new FeaturedGames_v1_0(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported FeaturedGames version is 1.0");
        }
        
		completeBuild(RiotApi.FeaturedGames.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.RecentGames newRecentGamesInterface(Region region, boolean autoRateControl) {
		RiotApi.RecentGames api = null;
	
        if (recentGamesVersion >= 1.3f) {
            api = new RecentGames_v1_3(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported RecentGames version is 1.3");
        }
        
		completeBuild(RiotApi.RecentGames.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.League newLeagueInterface(Region region, boolean autoRateControl) {
		RiotApi.League api = null;
	
        if (leagueVersion >= 2.5) {
            api = new League_v2_5(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported League version is 2.5");
        }
        
		completeBuild(RiotApi.League.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.StaticData newStaticDataInterface(Region region, boolean autoRateControl) {
		RiotApi.StaticData api = null;
	
        if (staticDataVersion >= 1.2) {
            api = new StaticData_v1_2(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported StaticData version is 1.2");
        }
        
		completeBuild(RiotApi.StaticData.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.Stats newStatsInterface(Region region, boolean autoRateControl) {
		RiotApi.Stats api = null;
	
    	if (statsVersion >= 1.3) {
    		api = new Stats_v1_3(apiKey, region);
    	} else {
    		throw new InvalidVersionException("Lowest supported StaticData version is 1.2");
    	}
    	
		completeBuild(RiotApi.Stats.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.LolStatus newStatusInterface(Region region, boolean autoRateControl) {
		RiotApi.LolStatus api = null;
	
        if (statusVersion >= 1.0f) {
            api = new LolStatus_v1_0(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported LolStatus version is 1.0");
        }
        
		completeBuild(RiotApi.LolStatus.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.Match newMatchInterface(Region region, boolean autoRateControl) {
		RiotApi.Match api = null;
	
        if (matchVersion >= 2.2f) {
            api = new Match_v2_2(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported Match version is 2.2");
        }
        
		completeBuild(RiotApi.Match.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.MatchList newMatchListInterface(Region region, boolean autoRateControl) {
		RiotApi.MatchList api = null;
	
        if (matchlistVersion >= 2.2) {
            api = new MatchList_v2_2(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported MatchListDto version is 2.2");
        }
        
		completeBuild(RiotApi.MatchList.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.Summoner newSummonerInterface(Region region, boolean autoRateControl) {
		RiotApi.Summoner api = null;
	
        if (summonerVersion >= 1.4f) {
        	api = new Summoner_v1_4(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported Summoner version is 1.4");
        }
        
		completeBuild(RiotApi.Summoner.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }

    public RiotApi.Team newTeamInterface(Region region, boolean autoRateControl) {
		RiotApi.Team api = null;
	
        if (teamVersion >= 2.4f) {
            api = new Team_v2_4(apiKey, region);
        } else {
            throw new InvalidVersionException("Lowest supported Team version is 2.4");
        }
        
		completeBuild(RiotApi.Team.getSupportedRegions(api.getVersion()), region, api, autoRateControl);
		return api;
    }
    
    private void completeBuild(Region[] supportedRegions, Region region, RiotApi api, boolean autoRateControl) {
    	boolean supported = false;
    	for (Region r : supportedRegions) {
    		if (r == region) {
    			supported = true;
    			break;
    		}
    	}
    	
    	if (!supported) {
    		throw new IllegalArgumentException("The API " + api.getClass().getSimpleName() + " is not supported for region " + region);
    	}
    	
    	if (autoRateControl && api.getRateType() == RateType.PERSONAL) {
    		api.setRateControl(true);
    	}
    	
    	api.setProxy(proxy);
    }

    /**
     * Used to create {@link ApiFactory} instances pointed at specific versions.
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
        
        private final ApiKey apiKey;
        
        public Builder(ApiKey apiKey) {
        	this.apiKey = apiKey;
        }

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

        public ApiFactory build() {
            ApiFactory factory = new ApiFactory(apiKey);
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
            factory.proxy = proxy;
            return factory;
        }
    }
}

package org.dc.riot.lol.rx.model.match;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains game frame information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Frame {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

	private Event[] events;
	private Map<String, ParticipantFrame> participantFrames;
	private Long timestamp;
	
	public Frame() {
		COUNT++;
	}
			
	/**
	 * @return List of events for this frame.
	 */
	public Event[] getEvents() {
		if (events == null) {
			return new Event[0];
		}
		
		return events;
	}
	
	/**
	 * @return Map of each participant ID to the participant's information for the frame.
	 */
	public Map<String, ParticipantFrame> getParticipantFrames() {
		if (participantFrames == null) {
			return new HashMap<String, ParticipantFrame>();
		}
		
		return participantFrames;
	}
	
	/**
	 * @return Represents how many milliseconds into the game the frame occurred.
	 * <code>-1</code> if not defined.
	 */
	public long getTimestamp() {
		if (timestamp == null) {
			return -1;
		}

		return timestamp.longValue();
	}
}

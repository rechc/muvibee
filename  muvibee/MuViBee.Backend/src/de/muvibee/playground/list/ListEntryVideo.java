package de.muvibee.playground.list;

import de.muvibee.media.Video;

@SuppressWarnings("serial")
public class ListEntryVideo extends ListEntry{

	public ListEntryVideo(Video video) {
		super(video, video.getDirector());
	}
	
}

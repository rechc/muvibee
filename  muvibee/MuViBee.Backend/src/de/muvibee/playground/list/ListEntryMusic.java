package de.muvibee.playground.list;

import de.muvibee.media.Music;

@SuppressWarnings("serial")
public class ListEntryMusic extends ListEntry{

	public ListEntryMusic(Music music) {
		super(music, music.getInterpreter());
	}
	
}

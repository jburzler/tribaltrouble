package com.oddlabs.tt.net;

@FunctionalInterface
public strictfp interface ChatListener {
	void chat(ChatMessage message);
}

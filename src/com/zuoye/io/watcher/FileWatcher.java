package com.zuoye.io.watcher;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {

	public static void main(String[] args) throws Exception {

		WatchService watchService = FileSystems.getDefault().newWatchService();
		Paths.get("F:/Google/2015-11/").register(watchService,
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		while (true) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.context() + "发生了" + event.kind()
						+ "事件");
			}
			if (!key.reset()) {
				break;
			}
		}
	}
}

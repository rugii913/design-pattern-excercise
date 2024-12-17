package pattern.behavioral.observer.guru;

import pattern.behavioral.observer.guru.editor.FileEditor;
import pattern.behavioral.observer.guru.listeners.FileSaveEmailAnnouncer;
import pattern.behavioral.observer.guru.listeners.FileOpenLogger;
import pattern.behavioral.observer.guru.publisher.EventManager;

// REFACTORING GURU - Observer in Java 코드 참고하여 일부 변형(https://refactoring.guru/design-patterns/observer/java/example#example-0--listeners-EmailNotificationListener-java)
// - 파일 편집기를 이용해 파일을 열 때마다 특정 경로의 로그에 기록하고, 파일을 저장하면 특정 이메일 주소로 메일을 보내는 상황을 가정
// - 목적이 잘 이해되지 않는 부분은 적당히 변경했음
public class ObserverMain {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager("open", "save");
        FileEditor editor = new FileEditor(eventManager);

        eventManager.subscribe("open", new FileOpenLogger("/some/path/file-open-log.txt"));
        eventManager.subscribe("save", new FileSaveEmailAnnouncer("example@aaa.aaa"));

        editor.openFile("test.txt");
        editor.saveFile();
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder logs = new StringBuilder();
        String[] res = {
                "drawables",
                "vectors",
                "icons"
        };
        String[] src = {
                "main",
                "test"
        };

        String[] games = {
                "src",
                "res",
                "savegames"
        };

        String[] files = {
                "Main",
                "Utils"
        };

        File dir = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\temp");
        if (dir.mkdir()) {
            logs.append("Каталог " + dir + " создан успешно");
            logs.append('\n');
        }

        File myFile = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\temp\\temp.txt");
        try {
            if (myFile.createNewFile()) {
                logs.append("Файл " + myFile + " записан успешно");
                logs.append('\n');
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        for (int i = 0; i < games.length; i++) {
            File newDir = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\" + games[i]);
            if (newDir.mkdir()) {
                logs.append("Каталог " + games[i] + " создан успешно");
                logs.append('\n');
            }
            if (games[i].equals("src")) {
                for (int j = 0; j < src.length; j++) {
                    File deepDir = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\src\\" + src[j]);
                    if (deepDir.mkdir()) {
                        logs.append("Каталог " + src[j] + " создан успешно");
                        logs.append('\n');
                    }
                }
            } else if (games[i].equals("res")) {
                for (int j = 0; j < res.length; j++) {
                    File deepDir = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\res\\" + res[j]);
                    if (deepDir.mkdir()) {
                        logs.append("Каталог " + res[j] + " создан успешно");
                        logs.append('\n');
                    }
                }
            }
        }
        for (int i = 0; i < files.length; i++) {
            File file = new File("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\src\\main\\" + files[i] + ".java");
            try {
                if (file.createNewFile()) {
                    logs.append("Файл " + files[i] + " записан успешно");
                    logs.append('\n');
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }


        try (FileWriter writer = new FileWriter("D:\\Учеба\\JAVA\\Progi\\Core\\Games\\Games\\temp\\temp.txt", false)) {
            writer.write(logs.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
package dev.arnoldatse.opensource.look4dev.core.handleFiles;

import java.util.Arrays;

public class CheckSupportedFileExtension {
    public static boolean check(String fileExtention, String[] authorizedExtensions) {
        return Arrays.stream(authorizedExtensions)
                .anyMatch(fileExtention::equalsIgnoreCase);
    }
}

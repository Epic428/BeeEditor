package com.teamresourceful.editorbackend.utils;

import org.springframework.util.ObjectUtils;


//TODO IGNORE THIS!!! LIKELY WILL NOT USE!
public class ResourceLocation {

    //Modified MC ResourceLocation for use with editor

    private static final String SEPARATOR = ":";

    private String namespace;
    private String path;

    public ResourceLocation() {
    }

    private ResourceLocation(String[] decomposedLocation) {
        this.namespace = ObjectUtils.isEmpty(decomposedLocation[0]) ? "minecraft" : decomposedLocation[0];
        this.path = decomposedLocation[1];
        if (!isValidNamespace(this.namespace)) { //TODO make custom exceptions
            throw new IllegalArgumentException("Non [a-z0-9_.-] character in namespace of location: " + this.namespace + ":" + this.path);
        } else if (!isValidPath(this.path)) {
            throw new IllegalArgumentException("Non [a-z0-9/._-] character in path of location: " + this.namespace + ":" + this.path);
        }
    }

    public ResourceLocation(String namespace, String path) {
        this(new String[]{namespace, path});
    }

    public ResourceLocation(String location) {
        this(decompose(location));
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return namespace + SEPARATOR + path;
    }

    /**
     * @return {@code true} if the specified {@code path} is valid: consists only of {@code [a-z0-9/._-]} characters
     */
    private static boolean isValidPath(String path) {
        for(int i = 0; i < path.length(); ++i) {
            if (!validPathChar(path.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return {@code true} if the specified {@code namespace} is valid: consists only of {@code [a-z0-9_.-]} characters
     */
    private static boolean isValidNamespace(String namespace) {
        for(int i = 0; i < namespace.length(); ++i) {
            if (!validNamespaceChar(namespace.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static String[] decompose(String location) {
        String[] strings = new String[]{"minecraft", location};
        int i = location.indexOf(SEPARATOR);
        if (i >= 0) {
            strings[1] = location.substring(i + 1);
            if (i >= 1) {
                strings[0] = location.substring(0, i);
            }
        }

        return strings;
    }

    private static boolean validPathChar(char pPathChar) {
        return pPathChar == '_' || pPathChar == '-' || pPathChar >= 'a' && pPathChar <= 'z' || pPathChar >= '0' && pPathChar <= '9' || pPathChar == '/' || pPathChar == '.';
    }

    private static boolean validNamespaceChar(char pNamespaceChar) {
        return pNamespaceChar == '_' || pNamespaceChar == '-' || pNamespaceChar >= 'a' && pNamespaceChar <= 'z' || pNamespaceChar >= '0' && pNamespaceChar <= '9' || pNamespaceChar == '.';
    }
}

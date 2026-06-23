package cam72cam.mod.config;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.Function;

public class ConfigFile {

    static {
        addMapper(int.class, i -> (i.toString()), Integer::parseInt);
        addMapper(Integer.class, i -> (i == null ? "" : i.toString()), Integer::parseInt);
        addMapper(long.class, i -> (i.toString()), Long::parseLong);
        addMapper(Long.class, i -> (i == null ? "" : i.toString()), Long::parseLong);
        addMapper(float.class, i -> (i.toString()), Float::parseFloat);
        addMapper(Float.class, i -> (i == null ? "" : i.toString()), Float::parseFloat);
        addMapper(double.class, i -> (i.toString()), Double::parseDouble);
        addMapper(Double.class, i -> (i == null ? "" : i.toString()), Double::parseDouble);

        addMapper(boolean.class, i -> (i.toString()), Boolean::parseBoolean);
        addMapper(Boolean.class, i -> (i == null ? "" : i.toString()), Boolean::parseBoolean);

        addMapper(String.class, i -> (i == null ? "" : i), l -> l);

    }

    public static class ConfigInstance {

        public ConfigInstance(Class<?> cls) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        public void read() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
        public void write() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }

    public static void write(Class cls) {
        ConfigInstance ci = new ConfigInstance(cls);
        ci.write();
    }

    public static void sync(Class cls) {
        ConfigInstance ci = new ConfigInstance(cls);
        ci.read();
        ci.write();
    }

    public static <T> void addMapper(Class<T> cls, Function<T, String> encoder, Function<String, T> decoder) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface File {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Comment {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Range {
        double min();
        double max();
    }


    public abstract static class Property {
        protected abstract <A extends Annotation> A getAnnotation(Class<A> cls);

        protected abstract void read(List<String> lines);

        protected abstract List<String> write();

        protected abstract String getName();

        protected String getName(String def) {
            Name n = getAnnotation(Name.class);
            return n == null ? def : n.value();
        }

        protected String getComment() {
            Comment n = getAnnotation(Comment.class);
            return n == null ? "" : n.value();
        }

        public Range getRange() {
            return getAnnotation(Range.class);
        }

        protected List<String> getFormattedComment() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }

    public static class PropertyField extends Property {

        private PropertyField(Field f) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected <A extends Annotation> A getAnnotation(Class<A> cls) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected void read(List<String> lines) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected List<String> write() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected String getName() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }

    public static class PropertyClass extends Property {

        public PropertyClass(Class<?> cls) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected <A extends Annotation> A getAnnotation(Class<A> cls) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected void read(List<String> lines) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected List<String> write() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        protected String getName() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }
}

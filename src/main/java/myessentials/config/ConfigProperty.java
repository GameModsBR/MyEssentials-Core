package myessentials.config;

import com.google.common.collect.ImmutableMap;
import net.minecraftforge.common.config.Property;

import java.util.Map;

public class ConfigProperty<T> {

    private T value;

    public final String name;
    public final String category;
    public final String comment;


    public ConfigProperty(String name, String category, String comment, T defaultValue) {
        this.name = name;
        this.category = category;
        this.comment = comment;
        this.value = defaultValue;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public boolean isClassType(Class clazz) {
        return value.getClass().isAssignableFrom(clazz);
    }

    public Property.Type getType() {
        return CONFIG_TYPES.get(value.getClass());
    }


    private static final Map<Class<?>, Property.Type> CONFIG_TYPES = ImmutableMap.<Class<?>, Property.Type> builder().put(Integer.class, Property.Type.INTEGER)
            .put(int.class, Property.Type.INTEGER).put(Integer[].class, Property.Type.INTEGER)
            .put(int[].class, Property.Type.INTEGER).put(Double.class, Property.Type.DOUBLE)
            .put(double.class, Property.Type.DOUBLE).put(Double[].class, Property.Type.DOUBLE)
            .put(double[].class, Property.Type.DOUBLE).put(Float.class, Property.Type.DOUBLE)
            .put(float.class, Property.Type.DOUBLE).put(Float[].class, Property.Type.DOUBLE)
            .put(float[].class, Property.Type.DOUBLE).put(Boolean.class, Property.Type.BOOLEAN)
            .put(boolean.class, Property.Type.BOOLEAN).put(Boolean[].class, Property.Type.BOOLEAN)
            .put(boolean[].class, Property.Type.BOOLEAN).put(String.class, Property.Type.STRING)
            .put(String[].class, Property.Type.STRING).build();

}

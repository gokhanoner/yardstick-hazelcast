package org.yardstickframework.hazelcast;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import org.yardstickframework.hazelcast.querymodel.Person;

public class PersonSerializableFactory implements PortableFactory {

    public static final int FACTORY_ID = 2;
    public static final int PERSON_ID = 2;

    @Override
    public Portable create(int classId) {
        if(classId == PERSON_ID) {
            return new Person();
        }
        return null;
    }
}

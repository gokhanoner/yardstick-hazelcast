/*
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.yardstickframework.hazelcast;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import java.io.*;

/**
 * Entity class for benchmark.
 */
public class SampleValue implements IdentifiedDataSerializable {
    /** */
    private int id;
    public static int sampleValueSize=1024;
    private byte[] value = new byte[sampleValueSize];

    /** */
    public SampleValue() {
        // No-op.
    }

    /**
     * @param id Id.
     */
    public SampleValue(int id) {
        this.id = id;
    }

    /**
     * @return Id.
     */
    public int id() {
        return id;
    }



    @Override
    public int getFactoryId() {
        return SampleValueSerializableFactory.FACTORY_ID;
    }

    @Override
    public int getId() {
        return SampleValueSerializableFactory.SAMPLE_ID;
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(id);
        out.writeByteArray(value);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        id = in.readInt();
        value = in.readByteArray();
    }


    /** {@inheritDoc} */
    @Override public String toString() {
        return "Value [id=" + id + ']';
    }

}

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

package org.yardstickframework.hazelcast.querymodel;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.*;


import java.io.*;

/**
 * Person record used for query test.
 */
public class Person implements DataSerializable {
    /** Person ID. */
    private int id;

    /** Organization ID. */
    private int orgId;

    /** First name. */
    private String firstName;

    /** Last name. */
    private String lastName;

    /** Salary. */
    private double salary;

    /**
     * Constructs empty person.
     */
    public Person() {
        // No-op.
    }

    /**
     * Constructs person record that is not linked to any organization.
     *
     * @param id Person ID.
     * @param firstName First name.
     * @param lastName Last name.
     * @param salary Salary.
     */
    public Person(int id, String firstName, String lastName, double salary) {
        this(id, 0, firstName, lastName, salary);
    }

    /**
     * Constructs person record.
     *
     * @param id Person ID.
     * @param orgId Organization ID.
     * @param firstName First name.
     * @param lastName Last name.
     * @param salary Salary.
     */
    public Person(int id, int orgId, String firstName, String lastName, double salary) {
        this.id = id;
        this.orgId = orgId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    /**
     * @return Person id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Person id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Organization id.
     */
    public int getOrganizationId() {
        return orgId;
    }

    /**
     * @param orgId Organization id.
     */
    public void setOrganizationId(int orgId) {
        this.orgId = orgId;
    }

    /**
     * @return Person first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName Person first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Person last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Person last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary Salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }


    /** {@inheritDoc} */
    @Override public boolean equals(Object o) {
        return this == o || (o instanceof Person) && id == ((Person)o).id;
    }

    /** {@inheritDoc} */
    @Override public int hashCode() {
        return id;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return "Person [firstName=" + firstName +
            ", id=" + id +
            ", orgId=" + orgId +
            ", lastName=" + lastName +
            ", salary=" + salary +
            ']';
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(id);
        out.writeInt(orgId);
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeDouble(salary);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        id = in.readInt();
        orgId = in.readInt();
        firstName = in.readUTF();
        lastName = in.readUTF();
        salary = in.readDouble();
    }

}

Need -- In the absence of Object streams, if u want to persist(save in permanent manner) state of objects or application data in binary manner --- prog has to convert all data to binary & then only it can be written to streams.

Object streams supply ready made functionality for the same.

Persistence ---saving  the state of the object on the binary stream.

Serialization/De-serialization

Ability to write or read  a Java object to/from  a binary stream

Supported since JDK 1.1

Saving an object to persistent storage(current example -- bin file later can be replaced by DB or sockets) is called persistence

Java provides a java.io.Serializable interface for checking serializability of java classes.(object)


Meaning --- At the time of serialization(writeObject) or de-serialization(readObject) --- JVM checks if the concerned object is Serializable(i.e has it implemented Serializable i/f) --if yes then only proceeds , otherwise throws Exception ---java.io.NotSerializableException

Serializable i/f has no methods and is a marker(tag) interface. Its role is to provide a run time marker for serialization.

Details 
What actually gets serialized?
When an object is serialized, mainly state of the object(=non-static & non-transient data members)  are preserved.
----------------------------------------------------

If a data member is an object(ref) , data members of the object are also serialized if that object’s class is serializable

eg : If Item class HAS - A reference of ShippingAddress

The tree of object’s data, including these sub-objects constitutes an object graph

eg : HM<String,Product> hm .....
out.writeObject(hm);
HM  -- String --Product (id,name,price,qty,category +shippingDetails)

If a serializable object contains reference to non-serializable element, the entire serialization fails




If the object graph contains a non-serializable object reference, the object can still be serialized if the non-serializable reference is marked “transient”

Details --- transient is a keyword in java.
Can be applied to data member.(primitive or ref)
transient implies ---skip from serialization.(meant for JVM)
Usage -- To persist --partial state of the serializable object
---------------------------------------




If super-class is serializable, then sub-class is automatically serializable.

If super-class is NOT serializable --- sub-class developer has to explicitely write the state of super-class.

What happens during deserialization?

When an object is deserialized, the JVM tries to bring the object back to life by making a new object on the heap that has the same state the serialized object had at the time it was serialized. 1. (Class.forName("com.app.core.Account")--class loading purpose,
2.  Class.newInstance(),
3. setting state of the object from bin stream)
The static/transient variables, which come back have either null (for object references) or as default
primitive values. 
Constructor of serializable class does not get called during de-serialization.

What are pre-requisites for de-serialization?
.class file for Class Obj to be de-serialized + Bin data stream containing state.

What is serialversion UID?
Each time an object is serialized,  the object (including every object in its graph) is 'stamped' with a version ID number for the object's class. The ID is called the serialVersionUlD, and it's computed based on information about the class structure. As an object is being deserialized, if the class has changed since the object was serialized, the class could have a different serialVersionUID, and deserialization will fail.(java.lang.InvalidClassException).  But you can control this - by adding your own UID.

-------------------------------
Serialization format overview
1. Magic no.
2. Serialization format version no.
3. Class desc -- class name,serial version uid,desc of data members(class signature)
4. State of the object.(non static & non transient data members)
-----------
Limitations
1. Java technology only
2. Difficult to maintain in case of changing class format
3. May lead to security leaks.





/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.proquest.services.example.xml;

/**
 * Class HelloMessageList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HelloMessageList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _helloMessageList.
     */
    private java.util.List<com.proquest.services.example.xml.HelloMessage> _helloMessageList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HelloMessageList() {
        super();
        this._helloMessageList = new java.util.ArrayList<com.proquest.services.example.xml.HelloMessage>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vHelloMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHelloMessage(
            final com.proquest.services.example.xml.HelloMessage vHelloMessage)
    throws java.lang.IndexOutOfBoundsException {
        this._helloMessageList.add(vHelloMessage);
    }

    /**
     * 
     * 
     * @param index
     * @param vHelloMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHelloMessage(
            final int index,
            final com.proquest.services.example.xml.HelloMessage vHelloMessage)
    throws java.lang.IndexOutOfBoundsException {
        this._helloMessageList.add(index, vHelloMessage);
    }

    /**
     * Method enumerateHelloMessage.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.proquest.services.example.xml.HelloMessage> enumerateHelloMessage(
    ) {
        return java.util.Collections.enumeration(this._helloMessageList);
    }

    /**
     * Method getHelloMessage.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.proquest.services.example.xml.HelloMessage at the given
     * index
     */
    public com.proquest.services.example.xml.HelloMessage getHelloMessage(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._helloMessageList.size()) {
            throw new IndexOutOfBoundsException("getHelloMessage: Index value '" + index + "' not in range [0.." + (this._helloMessageList.size() - 1) + "]");
        }

        return (com.proquest.services.example.xml.HelloMessage) _helloMessageList.get(index);
    }

    /**
     * Method getHelloMessage.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.proquest.services.example.xml.HelloMessage[] getHelloMessage(
    ) {
        com.proquest.services.example.xml.HelloMessage[] array = new com.proquest.services.example.xml.HelloMessage[0];
        return (com.proquest.services.example.xml.HelloMessage[]) this._helloMessageList.toArray(array);
    }

    /**
     * Method getHelloMessageCount.
     * 
     * @return the size of this collection
     */
    public int getHelloMessageCount(
    ) {
        return this._helloMessageList.size();
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateHelloMessage.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.proquest.services.example.xml.HelloMessage> iterateHelloMessage(
    ) {
        return this._helloMessageList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllHelloMessage(
    ) {
        this._helloMessageList.clear();
    }

    /**
     * Method removeHelloMessage.
     * 
     * @param vHelloMessage
     * @return true if the object was removed from the collection.
     */
    public boolean removeHelloMessage(
            final com.proquest.services.example.xml.HelloMessage vHelloMessage) {
        boolean removed = _helloMessageList.remove(vHelloMessage);
        return removed;
    }

    /**
     * Method removeHelloMessageAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.proquest.services.example.xml.HelloMessage removeHelloMessageAt(
            final int index) {
        java.lang.Object obj = this._helloMessageList.remove(index);
        return (com.proquest.services.example.xml.HelloMessage) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vHelloMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHelloMessage(
            final int index,
            final com.proquest.services.example.xml.HelloMessage vHelloMessage)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._helloMessageList.size()) {
            throw new IndexOutOfBoundsException("setHelloMessage: Index value '" + index + "' not in range [0.." + (this._helloMessageList.size() - 1) + "]");
        }

        this._helloMessageList.set(index, vHelloMessage);
    }

    /**
     * 
     * 
     * @param vHelloMessageArray
     */
    public void setHelloMessage(
            final com.proquest.services.example.xml.HelloMessage[] vHelloMessageArray) {
        //-- copy array
        _helloMessageList.clear();

        for (int i = 0; i < vHelloMessageArray.length; i++) {
                this._helloMessageList.add(vHelloMessageArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.proquest.services.example.xml.HelloMessageList
     */
    public static com.proquest.services.example.xml.HelloMessageList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.proquest.services.example.xml.HelloMessageList) org.exolab.castor.xml.Unmarshaller.unmarshal(com.proquest.services.example.xml.HelloMessageList.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}

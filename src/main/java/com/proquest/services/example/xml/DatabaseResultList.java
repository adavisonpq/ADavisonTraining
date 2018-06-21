/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.proquest.services.example.xml;

/**
 * Class DatabaseResultList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DatabaseResultList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _resultsList.
     */
    private java.util.List<java.lang.String> _resultsList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DatabaseResultList() {
        super();
        this._resultsList = new java.util.ArrayList<java.lang.String>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vResults
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addResults(
            final java.lang.String vResults)
    throws java.lang.IndexOutOfBoundsException {
        this._resultsList.add(vResults);
    }

    /**
     * 
     * 
     * @param index
     * @param vResults
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addResults(
            final int index,
            final java.lang.String vResults)
    throws java.lang.IndexOutOfBoundsException {
        this._resultsList.add(index, vResults);
    }

    /**
     * Method enumerateResults.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateResults(
    ) {
        return java.util.Collections.enumeration(this._resultsList);
    }

    /**
     * Method getResults.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getResults(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._resultsList.size()) {
            throw new IndexOutOfBoundsException("getResults: Index value '" + index + "' not in range [0.." + (this._resultsList.size() - 1) + "]");
        }

        return (java.lang.String) _resultsList.get(index);
    }

    /**
     * Method getResults.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getResults(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._resultsList.toArray(array);
    }

    /**
     * Method getResultsCount.
     * 
     * @return the size of this collection
     */
    public int getResultsCount(
    ) {
        return this._resultsList.size();
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
     * Method iterateResults.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.String> iterateResults(
    ) {
        return this._resultsList.iterator();
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
    public void removeAllResults(
    ) {
        this._resultsList.clear();
    }

    /**
     * Method removeResults.
     * 
     * @param vResults
     * @return true if the object was removed from the collection.
     */
    public boolean removeResults(
            final java.lang.String vResults) {
        boolean removed = _resultsList.remove(vResults);
        return removed;
    }

    /**
     * Method removeResultsAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeResultsAt(
            final int index) {
        java.lang.Object obj = this._resultsList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vResults
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setResults(
            final int index,
            final java.lang.String vResults)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._resultsList.size()) {
            throw new IndexOutOfBoundsException("setResults: Index value '" + index + "' not in range [0.." + (this._resultsList.size() - 1) + "]");
        }

        this._resultsList.set(index, vResults);
    }

    /**
     * 
     * 
     * @param vResultsArray
     */
    public void setResults(
            final java.lang.String[] vResultsArray) {
        //-- copy array
        _resultsList.clear();

        for (int i = 0; i < vResultsArray.length; i++) {
                this._resultsList.add(vResultsArray[i]);
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
     * com.proquest.services.example.xml.DatabaseResultList
     */
    public static com.proquest.services.example.xml.DatabaseResultList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.proquest.services.example.xml.DatabaseResultList) org.exolab.castor.xml.Unmarshaller.unmarshal(com.proquest.services.example.xml.DatabaseResultList.class, reader);
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

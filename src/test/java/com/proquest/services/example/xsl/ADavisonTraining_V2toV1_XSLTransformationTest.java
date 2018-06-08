package com.proquest.services.example.xsl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.xml.transform.TransformerException;

import org.junit.Test;

import com.proquest.services.utilities.xml.transformer.XMLDownCastingTransformer;

/**
 * @author Murali Jampani
 *
 */
public class ADavisonTraining_V2toV1_XSLTransformationTest {
	
    private static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String ADAVISONTRAINING_CURRENT_VERSION = "ADavisonTraining_v2";
    private static final String ADAVISONTRAINING_PREVIOUS_VERSION = "ADavisonTraining_v1";
    
    final String HELLO_MESSAGE_V2 = 
    		"<HelloMessage>\n" +
    				"<Language>English</Language>\n" +
    				"<Message>Hello world</Message>\n" +
    		"</HelloMessage>";
    
    final String HELLO_MESSAGE_V2_V1 = XML_VERSION;
    
    @Test
    public final void testAuthSchema() {
        String result;
        try {
            XMLDownCastingTransformer transformer = new XMLDownCastingTransformer(ADAVISONTRAINING_CURRENT_VERSION);
            result = transformer.transform(HELLO_MESSAGE_V2.toString(), ADAVISONTRAINING_PREVIOUS_VERSION);
            assertTrue(!result.contains("<Language>English</Language>"));
        } catch (TransformerException e) {
            fail("Transformation couldn't transform from " + ADAVISONTRAINING_CURRENT_VERSION + " to " + ADAVISONTRAINING_PREVIOUS_VERSION);
        }
    }
}

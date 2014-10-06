/* 
 * Copyright 2012 Devoteam http://www.devoteam.com
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 * 
 * This file is part of Multi-Protocol Test Suite (MTS).
 * 
 * Multi-Protocol Test Suite (MTS) is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the
 * License.
 * 
 * Multi-Protocol Test Suite (MTS) is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Multi-Protocol Test Suite (MTS).
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.devoteam.srit.xmlloader.asn1.dictionary;

import java.util.HashMap;

import com.devoteam.srit.xmlloader.asn1.ASNInitializer;

/**
 *
 * @author fhenry
 */
public class ASNDictionary 
{

	private static ASNDictionary _instance;
    
	private static HashMap<String, Embedded> embeddedsByIniial = new HashMap<String, Embedded> ();
	
    public static ASNDictionary getInstance()
    {
    	if (_instance != null)
    	{
    		return _instance;
    	}
    	return new ASNDictionary();
    }
	
	public static void addEmbedded(Embedded embedded) 
	{
		embeddedsByIniial.put(embedded.getInitial(), embedded);
	}
    
	public static void removeEmbedded(Embedded embedded) 
	{
		embeddedsByIniial.remove(embedded.getInitial());
	}
    
}
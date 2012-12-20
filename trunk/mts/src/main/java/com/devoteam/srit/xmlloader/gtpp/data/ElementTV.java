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

package com.devoteam.srit.xmlloader.gtpp.data;

import com.devoteam.srit.xmlloader.core.coding.binary.ElementAbstract;

import gp.utils.arrays.Array;
import gp.utils.arrays.DefaultArray;
import gp.utils.arrays.Integer08Array;
import gp.utils.arrays.SupArray;


/**
 *
 * @author Fabien Henry
 */
public class ElementTV extends ElementAbstract
{

    public ElementTV()
    {
    	
    }
    
    public void decodeFromArray(Array array, boolean bigLength, boolean fromdata) 
    {
        if (fromdata) {
	        this.id = new Integer08Array(array.subArray(0, 1)).getValue();
	        int length = getLengthElem() / 8;
	        this._value = array.subArray(0, length + 1);
	        this._fields = this._value.subArray(1);
        }
        else 
        {
        	array = new DefaultArray(getLengthElem() / 8 + 1);
	        this._value = array;
		    this._fields = this._value.subArray(1);
        }
    }

    public Array encodeToArray() {
        SupArray sup = new SupArray();
        Integer08Array idArray = new Integer08Array(this.id);
        sup.addLast(idArray);
		sup.addLast(_fields);
        return sup;
    }

    
}
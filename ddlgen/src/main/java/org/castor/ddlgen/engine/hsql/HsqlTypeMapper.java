/*
 * Copyright 2006 Le Duc Bao, Ralf Joachim
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.castor.ddlgen.engine.hsql;

import org.castor.ddlgen.AbstractTypeMapper;
import org.castor.ddlgen.DDLGenConfiguration;
import org.castor.ddlgen.typeinfo.NoParamType;
import org.castor.ddlgen.typeinfo.OptionalPrecisionDecimalsType;
import org.castor.ddlgen.typeinfo.RequiredLengthType;
import org.castor.ddlgen.typeinfo.RequiredPrecisionType;

/**
 * Final TypeMapper for HSQL database.
 * 
 * @author <a href="mailto:leducbao AT gmail DOT com">Le Duc Bao</a>
 * @author <a href="mailto:ralf DOT joachim AT syscon DOT eu">Ralf Joachim</a>
 * @version $Revision: 5951 $ $Date: 2006-04-25 16:09:10 -0600 (Tue, 25 Apr 2006) $
 * @since 1.1
 */
public final class HsqlTypeMapper extends AbstractTypeMapper {
    //--------------------------------------------------------------------------

    /**
     * Construct a TypeMapper for MySQL database using given configuration to 
     * get default parameters for parameterized types.
     * 
     * @param conf The configuration to get default parameter values from.
     */
    public HsqlTypeMapper(final DDLGenConfiguration conf) {
        super(conf);
    }

    //--------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    protected void initialize(final DDLGenConfiguration conf) {
        // numeric types
        this.add(new NoParamType("bit", "BIT"));
        this.add(new NoParamType("tinyint", "TINYINT"));
        this.add(new NoParamType("smallint", "SMALLINT"));
        this.add(new NoParamType("integer", "INTEGER"));
        this.add(new NoParamType("int", "INTEGER"));
        this.add(new NoParamType("bigint", "BIGINT"));
        
        this.add(new NoParamType("float", "FLOAT"));
        this.add(new RequiredPrecisionType("double", "DOUBLE PRECISION", conf));
        this.add(new NoParamType("real", "REAL"));
        this.add(new RequiredPrecisionType("numeric", "NUMERIC", conf));
        this.add(new OptionalPrecisionDecimalsType("decimal", "DECIMAL", conf));

        // character types
        this.add(new RequiredLengthType("char", "CHAR", conf));
        this.add(new RequiredLengthType("varchar", "VARCHAR", conf));
        this.add(new NoParamType("longvarchar", "LONGVARCHAR"));
        
        // date and time types
        this.add(new NoParamType("date", "DATE"));
        this.add(new NoParamType("time", "TIME"));
        this.add(new RequiredPrecisionType("timestamp", "TIMESTAMP", conf));
        
        // other types
        this.add(new NoParamType("binary", "BINARY"));
        this.add(new NoParamType("varbinary", "VARBINARY"));
        this.add(new NoParamType("longvarbinary", "LONGVARBINARY"));
        
        this.add(new NoParamType("other", "OTHER"));
        this.add(new NoParamType("javaobject", "OBJECT"));
        this.add(new NoParamType("blob", "OBJECT"));
        this.add(new NoParamType("clob", "OBJECT"));
    }

    //--------------------------------------------------------------------------
}

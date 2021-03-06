/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.carbondata.core.carbon;

import java.io.Serializable;

/**
 * Identifier class which will hold the table qualified name
 */
public class CarbonTableIdentifier implements Serializable {

  /**
   * database name
   */
  private String databaseName;

  /**
   * table name
   */
  private String tableName;

  /**
   * constructor
   */
  public CarbonTableIdentifier(String databaseName, String tableName) {
    this.databaseName = databaseName;
    this.tableName = tableName;
  }

  /**
   * return database name
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * return table name
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * @return table unique name
   */
  public String getTableUniqueName() {
    return databaseName + '_' + tableName;
  }

  /**
   * overridden equals method
   *
   * @param other
   * @return
   */
  @Override public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    CarbonTableIdentifier that = (CarbonTableIdentifier) other;
    if (!databaseName.equals(that.databaseName)) return false;
    return tableName.equals(that.tableName);

  }

  /**
   * overridden hashcode method
   *
   * @return
   */
  @Override public int hashCode() {
    int result = databaseName.hashCode();
    result = 31 * result + tableName.hashCode();
    return result;
  }

  /*
   * @return table unidque name
   */
  @Override public String toString() {
    return databaseName + '_' + tableName;
  }
}

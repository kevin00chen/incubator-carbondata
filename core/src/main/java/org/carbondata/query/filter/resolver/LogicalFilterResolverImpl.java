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
package org.carbondata.query.filter.resolver;

import org.carbondata.core.carbon.AbsoluteTableIdentifier;
import org.carbondata.core.carbon.datastore.IndexKey;
import org.carbondata.core.carbon.datastore.block.AbstractIndex;
import org.carbondata.core.keygenerator.KeyGenerator;
import org.carbondata.query.carbonfilterinterface.ExpressionType;
import org.carbondata.query.carbonfilterinterface.FilterExecuterType;
import org.carbondata.query.evaluators.DimColumnResolvedFilterInfo;

public class LogicalFilterResolverImpl implements FilterResolverIntf {
  protected FilterResolverIntf leftEvalutor;

  protected FilterResolverIntf rightEvalutor;

  private ExpressionType filterExpressionType;

  public LogicalFilterResolverImpl(FilterResolverIntf leftEvalutor,
      FilterResolverIntf rightEvalutor, ExpressionType filterExpressionType) {
    this.leftEvalutor = leftEvalutor;
    this.rightEvalutor = rightEvalutor;
    this.filterExpressionType = filterExpressionType;
  }

  /**
   * Logical filter resolver will return the left and right filter expresison
   * node for filter evaluation, so in this instance no implementation is required.
   *
   * @param absoluteTableIdentifier
   */
  @Override public void resolve(AbsoluteTableIdentifier absoluteTableIdentifier) {

  }

  /**
   * Since its a binary condition expresion the getLeft method will get the left
   * node of filter expression
   *
   * @return FilterResolverIntf.
   */
  public FilterResolverIntf getLeft() {
    return leftEvalutor;
  }

  /**
   * Since its a binary condition expresion the getRight method will get the left
   * node of filter expression
   *
   * @return FilterResolverIntf.
   */
  public FilterResolverIntf getRight() {
    return rightEvalutor;
  }

  @Override public DimColumnResolvedFilterInfo getDimColResolvedFilterInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public IndexKey getstartKey(KeyGenerator keyGenerator) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IndexKey getEndKey(AbstractIndex tableSegment, AbsoluteTableIdentifier tableIdentifier) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public FilterExecuterType getFilterExecuterType() {
    switch (filterExpressionType) {
      case OR:
        return FilterExecuterType.OR;
      case AND:
        return FilterExecuterType.AND;

      default:
        return null;
    }
  }
}
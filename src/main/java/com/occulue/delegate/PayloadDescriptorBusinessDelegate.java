/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.delegate;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.validator.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * PayloadDescriptor business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PayloadDescriptor related services in the case of a
 *       PayloadDescriptor business related service failing.
 *   <li>Exposes a simpler, uniform PayloadDescriptor interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PayloadDescriptor business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public abstract class PayloadDescriptorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PayloadDescriptorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PayloadDescriptor payloadDescriptor = null;
  private static final Logger LOGGER =
      Logger.getLogger(PayloadDescriptorBusinessDelegate.class.getName());
}

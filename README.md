# Application Architecture POC

POC for the ideas for the new application architecture. The architecture is broken down into the following tiers:


## Overview of Architectural Pattern

1. Rest/Resource tier
    This is a protocol translation tier which exposes business functionality via a RESTful interface which communicates
    via JSON. The structure of the JSON exchange format represents the consumer/client domain model. It is a domain
    considered from the point of view of a consumer and represents the ideal consumer model without regard for the
    domain in the System of Record (SoR).
    
2. Transactional Orchestration tier
    This tier represents the business functionality that is exposed from Khula. It performs orchestration of multiple 
    atomic services and represents the start of a transactional boundary. This tier is realised via Stateless Enterprise
    Bean (EJB) and is composed of multiple components which are not themselves EJBs. These include:
    
    a. Translators
    The responsibility of the translator beans are to be able to marshall a client consumable domain model to the 
    IAA domain model and back again. These beans are re-usable across the transactional orchestration tier and ensures
    that no other components need to be aware of the client consumable domain. These components are not stateful 
    components and is meant to be a functional layer which simply transforms one POJO to another.
    
    b. Validators, Rules and Business Logic 
    The responsibility of these components are to implement the Metropolitan business rules. These rules change at a 
    different rate to the structural components (see next layer) and therefore should be separated into its own component.
    These components are also re-usable across the transactional tier and are therefore not stateful components and 
    should not make any assumptions about the context in which they are used. The components only work at the IAA domain
    layer and are unaware of the client consumable front-end.
    
    c. Structural Managers
    The responsibility of these components are to perform the CRUD operations on the IAA domain. This layer is devoid
    of any Metropolitan specific business rules. The only rules enforced at this layer is the data integrity constraints
    (e.g. an agreement with a minimum cardinality of 1 on a role cannot be omitted. etc.) Most of the structural managers
    for the existing IAA domain has already been implemented by Silvermoon and should be used directly (i.e not wrapped
    in any further objects). However, the existing structural managers may be augmented by Metropolitan in the following
    cases:
    
        i)  A new server side entity is implemented which is not part of the Lunos domain. An example of this may be
            for the Do Not Contact preference. A new structural manager may be introduced by Metropolitan to handle this
            new entity.
        ii) A aggregation of the existing Lunos structural managers are required that represents a common use-case for
            Metropolitan and the composite behaviour is not exposed directly by any Lunos structural Manager. For example,
            a structural manager may be required that knows how to create a Party, attach it it a PartyRole and link it
            to an Agreement via a RoleInActual. 
            
3. Structural Managers
    The responsibility and implementation of this tier is as described above in 2c.
    
## About the POC

This POC will attempt to demonstrate the pattern described above using the following 2 use-cases:

1. Leads Management - specifically as it relates to the lead acquisition process.
2. Policy Admin - specifically as it relates to the ability to generate a quotation for a lead.

## Other Resources

This POC should be looked at in conjunction with the work done regarding the REST API design as it contains more
details about how the REST API should be constructed and interacts with the client consumable domain. This POC
augments this by focusing more on the other tiers and the interaction between the REST endpoints and the rest of the system.

## Contact

For more information or to discuss or contribute to this POC, please contact us:

* Dean James-Everett <DJames-Everett@metropolitan.co.za>
* Sreejith Sasidharan <Sreejith.Sasidharan@metropolitan.co.za>
* Garrick Van Schalkwyk <garrick@silvermoongroup.com>
* Debbie Claassen <dclaassen@metropolitan.co.za>
* Henry Brown <hbrown@metropolitan.co.za>

---- 

Last Update: April 2015
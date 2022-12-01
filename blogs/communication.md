# A note on communication patterns #

A well-architected system comprises of tens of, if not hundreds of, cohessive and loosely coupled entities. These entities can be in the form of objects, components, sub-systems and etc., The entities collaborate with each other to offer useful functionality to the use of the system. Such a collaboration requires fair deal of communication between these entities. 

The modes of communication between entities can be broadly categorized into synchronous communication and asynchronous communication.

## A. Synchrnous Communication ##

In synchronous mode of communication, the participating entities are aware of each other and usually they play the roles of service consumer and service provider. The flow communication can be presented as follows:

    1.1. Consumer makes a request to the provider and waits for a response.
    1.2. Provider processes the request and sends back a response.
    1.3. Consumer receives the response. 

Developing systems with this mode of communication is fairly simple. Testing such a system is also relatively easy. 

However, it is quite possible that the overall responsiveness and performance of the system suffers as the consumers are always at the mercy of the providers. The problem is more profound when the provider is not under the control of the system. For example, when an entity of the system make a request to an external provider such as REST endpoint, the entity gets blocked till the provider responds. 

Because of this, synchronous mode of communication is treated as blocking communication. 

## B. Asynchrnous Communication ##

In asynchrnous communication, the participating entities may or may not aware of each other. And for sure, they do not block each other. Instead of labelling the entities as consumers and providers, architects usually refer them as senders and receivers or publishers and subscribers. The flow of communication can be presenterd in two different ways: 

### B.1. Sender-Receiver Mode: ###

The following sequence explains this mode of communincation. 

    2.1. The sender connects with the receiver.
    2.2. The sender sends a message to the receiver.
    2.3. The receiver acknowledges the message and keep it in a queue.
    2.4. The sender and receiver proceed with their work independent of each other. 

Usually, the senders and receivers run as two separate threads, or processes. The point worth noting is that the sender does not expect immediate processing of message. The receiver may or may not process the message immediately. In fact, the receiver may not process the message et al. 

A callback mechanism also may be employed in this mode where the sender wants a follow-up action to take place when the message is processed by the receiver. In the step 2.2, the sender may send a function pointer or a callback command object to the reciever along with the message. The receiver can invoke this function or execute the command after processing the message. The original sender is not blocked. 

### B.2. Fire-And-Forget Mode: ###

The following are the steps involved in this mode of communication.

    3.1. The intended listening participants subscribe with a message broker. 
    3.2. The sender fires an event or publishes a message to the broker.
    3.3. The listerners receive the message and processes it

In this scheme, there is no need for the senders to know about the receivers and vice-versa. It is simply like the sender is shouting in the street and onlookers take note of it. They are not aware of each other. In case, a listener wants to communicate something back to the sender, the listener again fires an event or publishers a message to the broker. If the original sender listens the broker, ultimately the response message reaches the intended party. 

Since both these modes offer non-blocking communication mechanism, the system offers better performance and scalability. The microservice architecture often employes a message broker to reap these benefits. However, testing the workflows end-to-end and  implementing transactions across entities become quite a challenge. 

## Conclusion ##

As with any other patterns, the communication patterns are also to be used after due deligence. Every pattern has it's own pros and cons. 

**Krishna Mohan Koyya**   
<sub>https://www.glarimy.com | krishna@glarimy.com    
https://www.linkedin.com/in/krishnamohankoyya</sub>
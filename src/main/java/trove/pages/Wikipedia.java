package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Wikipedia extends Page {

    List<WikipediaArticle> articles = new ArrayList<>();

    public Wikipedia() {
        super("wikipedia", "Wikipedia",List.of());
        String misc = "Misc";


        addArticles("Crypto / TEA", """
                Tiny Encryption Algorithm
                XTEA
                XXTEA
                """);

        addArticles("Crypto / Rivest Cipher", """
                RC2
                RC4
                RC5
                RC6
                """);

        addArticle("Vigenère cipher", misc);
        addArticle("Caesar cipher", misc);
        addArticle("Frequency analysis", misc);
        addArticle("Kasiski examination", misc);
        addArticle("Cryptography", misc);
        addArticle("Hash-based cryptography", misc);
        addArticle("Non-commutative cryptography", misc);
        addArticle("RSA problem", misc);
        addArticle("IEEE P1363", misc);
        addArticle("NSA Suite B Cryptography", misc);
        addArticle("NIST Post-Quantum Cryptography Standardization", misc);
        addArticle("Algebraic Eraser", misc);
        addArticle("Efficient Probabilistic Public-Key Encryption Scheme", misc);
        addArticle("Hidden Field Equations", misc);
        addArticle("Lamport signature", misc);
        addArticle("McEliece cryptosystem", misc);
        addArticle("Merkle–Hellman knapsack cryptosystem", misc);
        addArticle("Naccache–Stern knapsack cryptosystem", misc);
        addArticle("XTR", misc);
        addArticle("Lattice-based cryptography", misc);
        addArticle("Learning with errors", misc);
        addArticle("Short integer solution problem", misc);
        addArticle("NTRUEncrypt", misc);
        addArticle("NTRUSign", misc);
        addArticle("Ring learning with errors key exchange", misc);
        addArticle("Ring learning with errors signature", misc);
        addArticle("BLISS signature scheme", misc);
        addArticle("NewHope", misc);
        addArticle("Discrete logarithm", misc);
        addArticle("Cramer–Shoup cryptosystem", misc);
        addArticle("Elliptic-curve Diffie–Hellman", misc);
        addArticle("Curve25519", misc);
        addArticle("Curve448", misc);
        addArticle("Elliptic Curve Digital Signature Algorithm", misc);
        addArticle("EdDSA", misc);
        addArticle("Encrypted key exchange", misc);
        addArticle("ElGamal encryption", misc);
        addArticle("ElGamal signature scheme", misc);
        addArticle("Schnorr signature", misc);
        addArticle("SPEKE", misc);
        addArticle("Secure Remote Password protocol", misc);
        addArticle("Station-to-Station protocol", misc);
        addArticle("Integer factorization", misc);
        addArticle("Blum–Goldwasser cryptosystem", misc);
        addArticle("Cayley–Purser algorithm", misc);
        addArticle("Damgård–Jurik cryptosystem", misc);
        addArticle("GMR (cryptography)", misc);
        addArticle("Goldwasser–Micali cryptosystem", misc);
        addArticle("Naccache–Stern cryptosystem", misc);
        addArticle("Rabin cryptosystem", misc);
        addArticle("RSA (cryptosystem)", misc);
        addArticle("Okamoto–Uchiyama cryptosystem", misc);
        addArticle("Schmidt-Samoa cryptosystem", misc);
        addArticle("Public-key cryptography", misc);
        addArticle("Optimal asymmetric encryption padding", misc);
        addArticle("Public key fingerprint", misc);
        addArticle("Web of trust", misc);
        addArticle("Key size", misc);
        addArticle("Identity-based cryptography", misc);
        addArticle("OpenPGP card", misc);
        addArticle("History of cryptography", misc);
        addArticle("Outline of cryptography", misc);
        addArticle("Cryptographic protocol", misc);
        addArticle("Cryptographic primitive", misc);
        addArticle("Cryptanalysis", misc);
        addArticle("Cryptocurrency", misc);
        addArticle("Cryptosystem", misc);
        addArticle("Cryptographic nonce", misc);
        addArticle("Cryptovirology", misc);
        addArticle("Key derivation function", misc);
        addArticle("Digital signature", misc);
        addArticle("Kleptography", misc);
        addArticle("Key (cryptography)", misc);
        addArticle("Key exchange", misc);
        addArticle("Key generator", misc);
        addArticle("Key schedule", misc);
        addArticle("Key stretching", misc);
        addArticle("Keygen", misc);
        addArticle("Cryptojacking", misc);
        addArticle("Ransomware", misc);
        addArticle("Random number generation", misc);
        addArticle("Pseudorandom noise", misc);
        addArticle("Secure channel", misc);
        addArticle("Subliminal channel", misc);
        addArticle("Encryption", misc);
        addArticle("End-to-end encryption", misc);
        addArticle("Information-theoretic security", misc);
        addArticle("Plaintext", misc);
        addArticle("Code (cryptography)", misc);
        addArticle("Ciphertext", misc);
        addArticle("Shared secret", misc);
        addArticle("Trapdoor function", misc);
        addArticle("Trusted timestamping", misc);
        addArticle("Key-based routing", misc);
        addArticle("Onion routing", misc);
        addArticle("Garlic routing", misc);
        addArticle("Kademlia", misc);
        addArticle("Mix network", misc);
        addArticle("Cryptographic hash function", misc);
        addArticle("Stream cipher", misc);
        addArticle("Symmetric-key algorithm", misc);
        addArticle("Authenticated encryption", misc);
        addArticle("Quantum key distribution", misc);
        addArticle("Quantum cryptography", misc);
        addArticle("Post-quantum cryptography", misc);
        addArticle("Message authentication code", misc);
        addArticle("Cryptographically secure pseudorandom number generator", misc);
        addArticle("Steganography", misc);
        addArticle("Hash function security summary", misc);
        addArticle("MD5", misc);
        addArticle("SHA-1", misc);
        addArticle("SHA-2", misc);
        addArticle("SHA-3", misc);
        addArticle("BLAKE (hash function)", misc);
        addArticle("Grøstl", misc);
        addArticle("JH (hash function)", misc);
        addArticle("Skein (hash function)", misc);
        addArticle("CubeHash", misc);
        addArticle("Elliptic curve only hash", misc);
        addArticle("Fast syndrome-based hash", misc);
        addArticle("GOST (hash function)", misc);
        addArticle("HAS-160", misc);
        addArticle("HAVAL", misc);
        addArticle("Kupyna", misc);
        addArticle("LSH (hash function)", misc);
        addArticle("MASH-1", misc);
        addArticle("MD2 (hash function)", misc);
        addArticle("MD4", misc);
        addArticle("MD6", misc);
        addArticle("MDC-2", misc);
        addArticle("N-hash", misc);
        addArticle("RIPEMD", misc);
        addArticle("RadioGatún", misc);
        addArticle("SM3 (hash function)", misc);
        addArticle("SWIFFT", misc);
        addArticle("Snefru", misc);
        addArticle("Streebog", misc);
        addArticle("Tiger (hash function)", misc);
        addArticle("Very smooth hash", misc);
        addArticle("Whirlpool (hash function)", misc);
        addArticle("Argon2", misc);
        addArticle("Balloon hashing", misc);
        addArticle("bcrypt", misc);
        addArticle("Password Hashing Competition", misc);
        addArticle("crypt (C)", misc);
        addArticle("Lyra2", misc);
        addArticle("PBKDF2", misc);
        addArticle("scrypt", misc);
        addArticle("HKDF", misc);
        addArticle("ARIA (cipher)", misc);
        addArticle("Camellia (cipher)", misc);
        addArticle("CAST-128", misc);
        addArticle("GOST (block cipher)", misc);
        addArticle("International Data Encryption Algorithm", misc);
        addArticle("LEA (cipher)", misc);

        addArticle("SEED", misc);
        addArticle("Skipjack (cipher)", misc);


        addArticle("Advanced Encryption Standard", misc);
        addArticle("Blowfish (cipher)", misc);
        addArticle("DES supplementary material", misc);
        addArticle("Triple DES", misc);
        addArticle("Serpent (cipher)", misc);
        addArticle("Twofish", misc);
        addArticle("CRYPTREC", misc);
        addArticle("NESSIE", misc);
        addArticle("NIST hash function competition", misc);
        addArticle("Merkle tree", misc);
        addArticle("Message authentication", misc);
        addArticle("Proof of work", misc);
        addArticle("Salt (cryptography)", misc);
        addArticle("Pepper (cryptography)", misc);
        addArticle("Hash collision", misc);
        addArticle("Merkle–Damgård construction", misc);
        addArticle("Sponge function", misc);
        addArticle("HAIFA construction", misc);
        addArticle("Collision attack", misc);
        addArticle("Preimage attack", misc);
        addArticle("Birthday attack", misc);
        addArticle("Side-channel attack", misc);
        addArticle("Length extension attack", misc);
        addArticle("CCM mode", misc);
        addArticle("ChaCha20-Poly1305", misc);
        addArticle("CWC mode", misc);
        addArticle("EAX mode", misc);
        addArticle("Galois/Counter Mode", misc);
        addArticle("IAPM (mode)", misc);
        addArticle("OCB mode", misc);
        addArticle("CBC-MAC", misc);
        addArticle("Data Authentication Algorithm", misc);
        addArticle("HMAC", misc);
        addArticle("One-key MAC", misc);
        addArticle("PMAC (cryptography)", misc);
        addArticle("Poly1305", misc);
        addArticle("SipHash", misc);
        addArticle("UMAC", misc);
        addArticle("VMAC", misc);
        addArticle("3-Way", misc);
        addArticle("Akelarre (cipher)", misc);
        addArticle("Anubis (cipher)", misc);
        addArticle("BaseKing", misc);
        addArticle("BassOmatic", misc);
        addArticle("BATON", misc);
        addArticle("BEAR and LION ciphers", misc);
        addArticle("CAST-256", misc);
        addArticle("Chiasmus (cipher)", misc);
        addArticle("CIKS-1", misc);
        addArticle("CIPHERUNICORN-A", misc);
        addArticle("CIPHERUNICORN-E", misc);
        addArticle("CLEFIA", misc);
        addArticle("Cellular Message Encryption Algorithm", misc);
        addArticle("Cobra ciphers", misc);
        addArticle("COCONUT98", misc);
        addArticle("Crab (cipher)", misc);
        addArticle("Cryptomeria cipher", misc);
        addArticle("CRYPTON", misc);
        addArticle("CS-Cipher", misc);
        addArticle("DEAL", misc);
        addArticle("DES-X", misc);
        addArticle("DFC (cipher)", misc);
        addArticle("E2 (cipher)", misc);
        addArticle("FEAL", misc);
        addArticle("FEA-M", misc);
        addArticle("FROG", misc);
        addArticle("GDES", misc);
        addArticle("Grand Cru (cipher)", misc);
        addArticle("Hasty Pudding cipher", misc);
        addArticle("Hierocrypt", misc);
        addArticle("ICE (cipher)", misc);
        addArticle("IDEA NXT", misc);
        addArticle("Intel Cascade Cipher", misc);
        addArticle("Iraqi block cipher", misc);
        addArticle("Kalyna (cipher)", misc);
        addArticle("KASUMI", misc);
        addArticle("KeeLoq", misc);
        addArticle("KHAZAD", misc);
        addArticle("Khufu and Khafre", misc);
        addArticle("KN-Cipher", misc);
        addArticle("Kuznyechik", misc);
        addArticle("Ladder-DES", misc);
        addArticle("LOKI97", misc);
        addArticle("LOKI", misc);
        addArticle("Lucifer (cipher)", misc);
        addArticle("M6 (cipher)", misc);
        addArticle("M8 (cipher)", misc);
        addArticle("MacGuffin (cipher)", misc);
        addArticle("Madryga", misc);
        addArticle("MAGENTA", misc);
        addArticle("MARS (cipher)", misc);
        addArticle("Mercy (cipher)", misc);
        addArticle("MESH (cipher)", misc);
        addArticle("MISTY1", misc);
        addArticle("MMB (cipher)", misc);
        addArticle("MULTI2", misc);
        addArticle("MultiSwap", misc);
        addArticle("New Data Seal", misc);
        addArticle("NewDES", misc);
        addArticle("Nimbus (cipher)", misc);
        addArticle("NOEKEON", misc);
        addArticle("NUSH", misc);
        addArticle("PRESENT", misc);
        addArticle("Prince (cipher)", misc);
        addArticle("Q (cipher)", misc);
        addArticle("REDOC", misc);
        addArticle("Red Pike (cipher)", misc);
        addArticle("S-1 block cipher", misc);
        addArticle("SAFER", misc);
        addArticle("SAVILLE", misc);
        addArticle("SC2000", misc);
        addArticle("SHACAL", misc);
        addArticle("SHARK", misc);
        addArticle("Simon (cipher)", misc);
        addArticle("SM4 (cipher)", misc);
        addArticle("Speck (cipher)", misc);
        addArticle("Spectr-H64", misc);
        addArticle("Square (cipher)", misc);
        addArticle("SXAL/MBAL", misc);
        addArticle("Threefish", misc);
        addArticle("Treyfer", misc);
        addArticle("UES (cipher)", misc);
        addArticle("Xmx", misc);

        addArticle("Zodiac (cipher)", misc);
        addArticle("3-subset meet-in-the-middle attack", misc);
        addArticle("Acoustic cryptanalysis", misc);
        addArticle("Advanced Encryption Standard process", misc);
        addArticle("Avalanche effect", misc);
        addArticle("Biclique attack", misc);
        addArticle("Black-bag cryptanalysis", misc);
        addArticle("Block cipher mode of operation", misc);
        addArticle("Block size (cryptography)", misc);
        addArticle("Boomerang attack", misc);
        addArticle("Chi-squared test", misc);
        addArticle("Confusion and diffusion", misc);
        addArticle("Davies attack", misc);
        addArticle("Differential cryptanalysis", misc);
        addArticle("Differential fault analysis", misc);
        addArticle("Differential-linear attack", misc);
        addArticle("Distinguishing attack", misc);
        addArticle("EFF DES cracker", misc);
        addArticle("Electromagnetic attack", misc);
        addArticle("Feistel cipher", misc);
        addArticle("Higher-order differential cryptanalysis", misc);
        addArticle("Impossible differential cryptanalysis", misc);
        addArticle("Initialization vector", misc);
        addArticle("Integral cryptanalysis", misc);
        addArticle("Interpolation attack", misc);
        addArticle("Kendall rank correlation coefficient", misc);
        addArticle("Key whitening", misc);
        addArticle("Known-key distinguishing attack", misc);
        addArticle("Lai–Massey scheme", misc);
        addArticle("Linear cryptanalysis", misc);
        addArticle("Meet-in-the-middle attack", misc);
        addArticle("Mod n cryptanalysis", misc);
        addArticle("Padding (cryptography)", misc);
        addArticle("Partitioning cryptanalysis", misc);
        addArticle("Permutation box", misc);
        addArticle("Piling-up lemma", misc);
        addArticle("Power analysis", misc);
        addArticle("Product cipher", misc);
        addArticle("Rebound attack", misc);
        addArticle("Related-key attack", misc);
        addArticle("Rotational cryptanalysis", misc);
        addArticle("Rubber-hose cryptanalysis", misc);
        addArticle("S-box", misc);
        addArticle("Slide attack", misc);
        addArticle("Substitution–permutation network", misc);
        addArticle("Time/memory/data tradeoff attack", misc);
        addArticle("Timing attack", misc);
        addArticle("Truncated differential cryptanalysis", misc);
        addArticle("Weak key", misc);
        addArticle("Whitening transformation", misc);
        addArticle("XSL attack", misc);
        addArticles(misc, """
                Achterbahn
                F-FCSR
                FISH (cipher)
                ISAAC (cipher)
                MUGI
                ORYX
                Panama (cryptography)
                Phelix
                Pike (cipher)
                Py (cipher)
                QUAD (cipher)
                Scream (cipher)
                SEAL (cipher)
                SNOW
                SOBER
                SOBER-128
                VEST
                Variably Modified Permutation Composition
                WAKE (cipher)
                Shrinking generator
                Self-shrinking generator
                Alternating step generator
                Shift register
                Linear-feedback shift register
                Nonlinear-feedback shift register
                T-function
                Correlation attack
                Correlation immunity
                Stream cipher attacks
                A5/1
                A5/2
                Crypto-1
                E0 (cipher)
                HC-256
                Rabbit (cipher)
                Salsa20
                SOSEMANUK
                Grain (cipher)
                MICKEY
                Trivium (cipher)
                Wi-Fi Protected Access
                Wired Equivalent Privacy
                Aircrack-ng
                IEEE 802.11i-2004
                Pre-shared key
                TLS-PSK
                Temporal Key Integrity Protocol
                ARP spoofing
                IPsec
                Domain Name System Security Extensions
                Kerberos (protocol)
                Resource Public Key Infrastructure
                X.509
                XKMS
                DomainKeys Identified Mail
                DMARC
                Pretty Good Privacy
                Sender ID
                Sender Policy Framework
                S/MIME
                Transport Layer Security
                DNS-based Authentication of Named Entities
                DNS over HTTPS
                DNS over TLS
                DNS Certification Authority Authorization
                Internet Key Exchange
                Layer 2 Tunneling Protocol
                OpenVPN
                Point-to-Point Tunneling Protocol
                WireGuard
                SOAP
                XML Information Set
                World Wide Web Consortium
                Processing Instruction
                Standard Generalized Markup Language
                DocBook
                EPUB
                RELAX NG
                Schematron
                XPath
                XSLT
                Document type definition
                IBM Generalized Markup Language
                Document Schema Definition Languages
                List of XML and HTML character entity references
                Document type declaration
                Formal Public Identifier
                System identifier
                Document Definition Markup Language
                Schema for Object-Oriented XML
                MSXML
                Media type
                XML data binding
                Document Object Model
                Simple API for XML
                Java API for XML Processing
                List of XML markup languages
                List of types of XML schemas
                StAX
                Dom4j
                Jakarta XML Binding
                Streaming XML
                XQuery API for Java
                Apache Xerces
                Apache Commons
                Apache XMLBeans
                YAML
                MIME
                TOML
                Lightweight markup language
                XPath 2.0
                XPath 3
                Query language
                SQL
                Datalog
                GraphQL
                HTSQL
                Language Integrated Query
                Lightweight Directory Access Protocol
                Molecular Query Language
                Couchbase Server
                Object Query Language
                Object Constraint Language
                WinFS
                PQL
                PTQL
                QUEL query languages
                RDF query language
                SPARQL
                Resource Description Framework
                NoSQL
                MongoDB
                Federated search
                Geographic information system
                Geography Markup Language
                Well-known text representation of geometry
                OGC GeoSPARQL
                SPARUL
                XQuery
                List of SPARQL implementations
                Semantic integration
                SPARQL Query Results XML Format
                SPARQL Syntax Expressions
                Wikidata
                RDF Schema
                Web Ontology Language
                XUL
                Cypher (query language)
                Neo4j
                Comparison of layout engines (XML)
                XSL Formatting Objects
                EXSLT
                XLink
                XML Base
                XPointer
                XML Signature
                XML Encryption
                Dynamic Host Configuration Protocol
                Domain Name System
                File Transfer Protocol
                Hypertext Transfer Protocol
                HTTPS
                Internet Message Access Protocol
                Internet Relay Chat
                Media Gateway Control Protocol
                MQTT
                Network News Transfer Protocol
                Network Time Protocol
                Post Office Protocol
                Precision Time Protocol
                Sun RPC
                Real-time Transport Protocol
                Real Time Streaming Protocol
                Session Initiation Protocol
                Simple Mail Transfer Protocol
                Simple Network Management Protocol
                Secure Shell
                Telnet
                XMPP
                Application layer
                OSI model
                Transport layer
                Internet layer
                Link layer
                Tunneling protocol
                Point-to-Point Protocol
                IPv4
                IPv6
                Internet Control Message Protocol
                Internet Control Message Protocol for IPv6
                Neighbor Discovery Protocol
                Explicit Congestion Notification
                Internet Group Management Protocol
                Transmission Control Protocol
                User Datagram Protocol
                Datagram Congestion Control Protocol
                Stream Control Transmission Protocol
                Resource Reservation Protocol
                QUIC
                HTTP/2
                SPDY
                Common Object Request Broker Architecture
                Internet Communications Engine
                Distributed Component Object Model
                Object Linking and Embedding
                Component Object Model
                ActiveX
                Browser Helper Object
                COM Interop
                Jakarta Enterprise Beans
                Microsoft RPC
                Universal Coded Character Set
                MAPI
                Open Software Foundation
                The Open Group
                Dynamic Data Exchange
                .NET Framework
                DirectX
                Direct3D
                XPCOM
                Interface description language
                Remote procedure call
                Open Database Connectivity
                Web Services Description Language
                Business Process Execution Language
                Representational state transfer
                URL
                XML Schema (W3C)
                SDEP
                Web Application Description Language
                Apache CXF
                WS-Addressing
                WS-Policy
                WS-ReliableMessaging
                WS-SecureConversation
                WS-Security
                WS-SecurityPolicy
                Jakarta XML Web Services
                Jakarta RESTful Web Services
                Jakarta Messaging
                Message-oriented middleware
                Object request broker
                .NET Remoting
                Windows Communication Foundation
                Java remote method invocation
                General Inter-ORB Protocol
                RMI-IIOP
                Message broker
                Publish–subscribe pattern
                Messaging pattern
                Message passing
                Message queue
                Data Distribution Service
                Object Management Group
                Association for Computing Machinery
                Producer–consumer problem
                Push technology
                WebSub
                Apache ActiveMQ
                Apache Kafka
                HornetQ
                JBoss Messaging
                Open Message Queue
                RabbitMQ
                Redis
                ZeroMQ
                WSO2
                Comparison of business integration software
                Stored procedure
                Advanced Message Queuing Protocol
                Streaming Text Oriented Messaging Protocol
                Enterprise service bus
                Enterprise messaging system
                Amazon Simple Queue Service
                OpenJMS
                Jakarta Activation
                WS-Policy4MASC
                Eclipse Metro
                Jakarta SOAP with Attachments
                Jakarta EE
                List of web service specifications
                XML namespace
                XInclude
                SOAP-over-UDP
                Message Transmission Optimization Mechanism
                JSON-WSP
                WS-Discovery
                Multicast
                IP multicast
                Web Services for Devices
                Devices Profile for Web Services
                Bonjour (software)
                OSGi
                Simple Service Discovery Protocol
                Universal Plug and Play
                Web Services Discovery
                Web Services Inspection Language
                WS-I Basic Profile
                S-RAMP
                Service-oriented architecture
                WS-MetadataExchange
                Web Services Semantics
                Web Services Resource Framework
                WS-Trust
                WS-Federation
                Security Assertion Markup Language
                XACML
                P3P
                Simple Soap Binding Profile
                Service choreography
                XPDL
                Web Services Conversation Language
                WS-Atomic Transaction
                WS-Coordination
                WS-CAF
                WS-Transaction
                WS-Context
                WS-Management
                Web Services Distributed Management
                Web Services for Remote Portlets
                ebXML
                Ephemeral port
                6to4
                Network Driver Interface Specification
                Network interface controller
                NDISwrapper
                Driver wrapper
                Linux
                FreeBSD
                NetBSD
                BeOS
                magnussoft ZETA
                Data link layer
                Medium access control
                Network layer
                Internet protocol suite
                pcap
                VLAN
                Windows Driver Model
                Windows Driver Kit
                Open Data-Link Interface
                Uniform Driver Interface
                Preboot Execution Environment
                PC/TCP Packet Driver
                Ethernet
                Wi-Fi
                Fibre Channel
                Asynchronous Transfer Mode
                ARCNET
                Duplex (telecommunications)
                Computer hardware
                Expansion card
                Bus (computing)
                Motherboard
                USB
                Dongle
                Interrupt
                TCP offload engine
                Physical layer
                Protocol stack
                Local area network
                IEEE 802
                MAC address
                Server (computing)
                Chipset
                System on a chip
                Modular connector
                BNC connector
                Attachment Unit Interface
                Fast Ethernet
                Gigabit Ethernet
                Ethernet over twisted pair
                10 Gigabit Ethernet
                Small Form-factor Pluggable
                Fiber-optic communication
                Light-emitting diode
                Polling (computer science)
                Central processing unit
                Peripheral
                Interrupt request (PC architecture)
                Programmed input–output
                System bus
                Latency (engineering)
                Queue (abstract data type)
                Hash function
                Multi-core processor
                Network packet
                Locality of reference
                CPU cache
                Context switch
                Single-root input/output virtualization
                PCI configuration space
                Field-programmable gate array
                User space and kernel space
                Kernel (operating system)
                Converged network adapter
                Host adapter
                Direct memory access
                Loopback
                Network monitoring interface card
                Virtual network interface
                Wireless network interface controller
                Peripheral Component Interconnect
                Mobile broadband modem
                Router (computing)
                Instruction set architecture
                IA-32
                x86-64
                INF file
                DragonFly BSD
                Windows Driver Frameworks
                List of router firmware projects
                Cabinet (file format)
                DebWRT
                LibreCMC
                Longene
                ReactOS
                Cygwin
                Microsoft POSIX subsystem
                Windows Services for UNIX
                Interix
                Windows Subsystem for Linux
                DJGPP
                Hamilton C shell
                MinGW
                Mingw-w64
                MKS Toolkit
                PowerShell
                UWIN
                GnuWin32
                UnxUtils
                Wabi (software)
                Award Software
                Wine (software)
                WINE@Etersoft
                Cedega (software)
                CrossOver (software)
                Darwine
                Proton (software)
                Comparison of platform virtualization software
                Cooperative Linux
                Merge (software)
                TopologiLinux
                Application Programming Interface for Windows
                Captive NTFS
                Windows Interface Source Environment
                Computer network
                Multiplexing
                Internet Protocol
                Internetwork Packet Exchange
                DECnet
                Flow control (data)
                Automatic repeat request
                NetBIOS Frames
                X.25
                LAPB
                IEEE 802.2
                IEEE 802.3
                Ethernet frame
                Token Ring
                IEEE 802.11
                Carrier-sense multiple access with collision detection
                EtherType
                High-Level Data Link Control
                Cisco HDLC
                Modem
                Link Access Procedure for Modems
                General Packet Radio Service
                SNDCP
                ITU-T
                G.hn
                Subnetwork Access Protocol
                Virtual circuit multiplexing
                Routing
                NetBIOS
                Logical link control
                LAN Manager
                IBM LAN Server
                Windows 3.1x
                Windows 95
                Windows NT
                NetBIOS over TCP/IP
                IPX/SPX
                Datagram
                Virtual circuit
                Broadcasting (networking)
                NetWare
                Broadcast domain
                Network bridge
                Connectionless communication
                OS/2
                Windows 2000
                Windows XP
                Session layer
                Operating system
                IP address
                Hostname
                Client–server model
                IBM PS/2
                Nickname
                Connection-oriented communication
                Server Message Block
                Network address
                Windows Internet Name Service
                LMHOSTS
                hosts (file)
                Web browser
                Command-line interface
                Microsoft Windows
                Windows Messenger service
                Remote access service
                File server
                Windows domain
                Browser service
                Domain controller
                MS-DOS
                Windows NT 3.1
                Code page
                Data Encryption Standard
                Parity bit
                ASCII
                Password
                Block cipher
                Rainbow table
                Brute-force attack
                NT LAN Manager
                Password cracking
                Graphics processing unit
                Man-in-the-middle attack
                Pass the hash
                Ophcrack
                RainbowCrack
                Hashcat
                L0phtCrack
                Cain and Abel (software)
                Unicode
                UTF-16
                56-bit encryption
                Windows Vista
                Windows Server 2008
                Backward compatibility
                Windows Me
                Active Directory
                Group Policy
                Reverse engineering
                Samba (software)
                IBM AIX
                DOS
                Windows Preinstallation Environment
                Dictionary attack
                Remote Initial Program Load
                Security Account Manager
                MS-CHAP
                Authentication
                BSD Authentication
                Electronic authentication
                Generic Security Services Application Program Interface
                Java Authentication and Authorization Service
                Pluggable authentication module
                Simple Authentication and Security Layer
                Security Support Provider Interface
                XUDA
                Authentication protocol
                ACF2
                Authentication and Key Agreement
                CAVE-based authentication
                Challenge-Handshake Authentication Protocol
                Central Authentication Service
                CRAM-MD5
                Diameter (protocol)
                Extensible Authentication Protocol
                Host Identity Protocol
                IndieAuth
                OAuth
                OpenID
                Password-authenticated key agreement
                Password Authentication Protocol
                Protected Extensible Authentication Protocol
                RADIUS
                Resource Access Control Facility
                TACACS
                Woo–Lam
                Virtual private network
                IEEE 802.1X
                Virtualization
                Network traffic
                Network administrator
                Network switch
                Network planning and design
                Node (networking)
                Data link
                Network security
                Traffic management
                Internet hosting service
                Data center
                VLAN hopping
                Networking hardware
                Networking cables
                Frame (networking)
                IEEE 802.1Q
                Trunking
                Quality of service
                Network segmentation
                Supernetwork
                Network congestion
                Service discovery
                Address Resolution Protocol
                Subnetwork
                Voice over IP
                Network management
                Storage area network
                DMZ (computing)
                Cloud computing
                HiperSocket
                InfiniBand
                Spanning tree
                IEEE 802.1ad
                IEEE 802.1ah-2008
                Collision domain
                Private network
                Network address translation
                Link aggregation
                Internet backbone
                Wiring closet
                IEEE 802.1
                Proprietary protocol
                Cisco Inter-Switch Link
                Fiber Distributed Data Interface
                IEEE 802.10
                IEEE 802.1aq
                VLAN Trunking Protocol
                Cisco Catalyst
                Multiple Registration Protocol
                VLAN Management Policy Server
                Multiprotocol Label Switching
                HVLAN
                Network virtualization
                Private VLAN
                Software-defined networking
                Switch virtual interface
                Virtual Extensible LAN
                Virtual Private LAN Service
                VLAN access control list
                Wide area network
                I2O
                Internet Security Association and Key Management Protocol
                Link-Local Multicast Name Resolution
                Remote direct memory access
                Common Information Model (computing)
                Distributed Management Task Force
                Web-Based Enterprise Management
                Unified Modeling Language
                CIM Schema
                Systems Management Architecture for Server Hardware
                Storage Management Initiative – Specification
                Windows Management Instrumentation
                Storage Networking Industry Association
                Desktop and mobile Architecture for System Hardware
                Finite-state machine
                Model of computation
                Abstract machine
                State (computer science)
                Input (computer science)
                Deterministic finite automaton
                Nondeterministic finite automaton
                Turing machine
                Automata theory
                Computational problem
                Theoretical computer science
                Computer science
                Data structure
                Computational complexity theory
                Computational complexity
                Average-case complexity
                Quicksort
                Sorting algorithm
                Communication complexity
                Very Large Scale Integration
                Communication protocol
                Gap-Hamming problem
                Hoeffding's inequality
                Quantum entanglement
                Nonnegative rank (linear algebra)
                Decision tree model
                Streaming algorithm
                Space–time tradeoff
                Memoization
                Data compression
                Baby-step giant-step
                Dynamic programming
                Bellman equation
                Value function
                Hamilton–Jacobi–Bellman equation
                Partial differential equation
                Social welfare function
                Inada conditions
                Backward induction
                Dijkstra's algorithm
                Routing protocol
                Interior gateway protocol
                Link-state routing protocol
                Open Shortest Path First
                IS-IS
                Distance-vector routing protocol
                Routing Information Protocol
                Exterior gateway protocol
                Autonomous system (Internet)
                Border Gateway Protocol
                Path-vector routing protocol
                Enhanced Interior Gateway Routing Protocol
                Bird Internet routing daemon
                Quagga (software)
                GNU Zebra
                OpenBGPD
                OpenOSPFD
                XORP
                Static routing
                Dynamic routing
                Hierarchical state routing
                Optimized Link State Routing Protocol
                B.A.T.M.A.N.
                ZHLS-GF""");

    }

    private void addArticles(String category, String articles) {
        new BufferedReader(new StringReader(articles)).lines().forEach(title -> addArticle(title, category));
    }


    private void addArticle(String title, String category) {
        articles.add(new WikipediaArticle(title, category));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {
        Set<String> visited = new HashSet<>();
        Map<String, List<WikipediaArticle>> byCategory = new HashMap<>();
        for (WikipediaArticle article : articles) {
            String category = article.getCategory();
            if (!byCategory.containsKey(category)) {
                byCategory.put(category, new ArrayList<>());
            }
            byCategory.get(category).add(article);
        }
        pw.println("<ul>");
        byCategory.keySet().stream().sorted().forEach(category -> {
            List<WikipediaArticle> links = byCategory.get(category);
            pw.println("<li>" + category + " (" + links.size() + ")");
            pw.println("<ul>");
            links.stream().sorted(Comparator.comparing(wikipediaArticle -> wikipediaArticle.getTitle().toUpperCase())).forEach(article -> {
                if (visited.contains(article.getTitle())) {
                    System.out.println(article.getTitle());
                }
                String link = externalLink("https://en.wikipedia.org/wiki/" + article.getCode(), article.getTitle());
                pw.println("<li>" + link + "</li>");
                visited.add(article.getTitle());
            });
            pw.println("</ul>");
            pw.println("</li>");
        });
        pw.println("</ul>");
    }
}

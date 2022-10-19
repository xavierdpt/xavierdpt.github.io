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
        addArticles("""
                Tiny Encryption Algorithm
                XTEA
                XXTEA
                RC2
                RC4
                RC5
                RC6
                Vigenère cipher
                Caesar cipher
                Frequency analysis
                Kasiski examination
                Cryptography
                Hash-based cryptography
                Non-commutative cryptography
                RSA problem
                IEEE P1363
                NSA Suite B Cryptography
                NIST Post-Quantum Cryptography Standardization
                Algebraic Eraser
                Efficient Probabilistic Public-Key Encryption Scheme
                Hidden Field Equations
                Lamport signature
                McEliece cryptosystem
                Merkle–Hellman knapsack cryptosystem
                Naccache–Stern knapsack cryptosystem
                XTR
                Lattice-based cryptography
                Learning with errors
                Short integer solution problem
                NTRUEncrypt
                NTRUSign
                Ring learning with errors key exchange
                Ring learning with errors signature
                BLISS signature scheme
                NewHope
                Discrete logarithm
                Cramer–Shoup cryptosystem
                Elliptic-curve Diffie–Hellman
                Curve25519
                Curve448
                Elliptic Curve Digital Signature Algorithm
                EdDSA
                Encrypted key exchange
                ElGamal encryption
                ElGamal signature scheme
                Schnorr signature
                SPEKE
                Secure Remote Password protocol
                Station-to-Station protocol
                Integer factorization
                Blum–Goldwasser cryptosystem
                Cayley–Purser algorithm
                Damgård–Jurik cryptosystem
                GMR (cryptography)
                Goldwasser–Micali cryptosystem
                Naccache–Stern cryptosystem
                Rabin cryptosystem
                RSA (cryptosystem)
                Okamoto–Uchiyama cryptosystem
                Schmidt-Samoa cryptosystem
                Public-key cryptography
                Optimal asymmetric encryption padding
                Public key fingerprint
                Web of trust
                Key size
                Identity-based cryptography
                OpenPGP card
                History of cryptography
                Outline of cryptography
                Cryptographic protocol
                Cryptographic primitive
                Cryptanalysis
                Cryptocurrency
                Cryptosystem
                Cryptographic nonce
                Cryptovirology
                Key derivation function
                Digital signature
                Kleptography
                Key (cryptography)
                Key exchange
                Key generator
                Key schedule
                Key stretching
                Keygen
                Cryptojacking
                Ransomware
                Random number generation
                Pseudorandom noise
                Secure channel
                Subliminal channel
                Encryption
                End-to-end encryption
                Information-theoretic security
                Plaintext
                Code (cryptography)
                Ciphertext
                Shared secret
                Trapdoor function
                Trusted timestamping
                Key-based routing
                Onion routing
                Garlic routing
                Kademlia
                Mix network
                Cryptographic hash function
                Stream cipher
                Symmetric-key algorithm
                Authenticated encryption
                Quantum key distribution
                Quantum cryptography
                Post-quantum cryptography
                Message authentication code
                Cryptographically secure pseudorandom number generator
                Steganography
                Hash function security summary
                MD5
                SHA-1
                SHA-2
                SHA-3
                BLAKE (hash function)
                Grøstl
                JH (hash function)
                Skein (hash function)
                CubeHash
                Elliptic curve only hash
                Fast syndrome-based hash
                GOST (hash function)
                HAS-160
                HAVAL
                Kupyna
                LSH (hash function)
                MASH-1
                MD2 (hash function)
                MD4
                MD6
                MDC-2
                N-hash
                RIPEMD
                RadioGatún
                SM3 (hash function)
                SWIFFT
                Snefru
                Streebog
                Tiger (hash function)
                Very smooth hash
                Whirlpool (hash function)
                Argon2
                Balloon hashing
                bcrypt
                Password Hashing Competition
                crypt (C)
                Lyra2
                PBKDF2
                scrypt
                HKDF
                ARIA (cipher)
                Camellia (cipher)
                CAST-128
                GOST (block cipher)
                International Data Encryption Algorithm
                LEA (cipher)
                SEED
                Skipjack (cipher)
                Advanced Encryption Standard
                Blowfish (cipher)
                DES supplementary material
                Triple DES
                Serpent (cipher)
                Twofish
                CRYPTREC
                NESSIE
                NIST hash function competition
                Merkle tree
                Message authentication
                Proof of work
                Salt (cryptography)
                Pepper (cryptography)
                Hash collision
                Merkle–Damgård construction
                Sponge function
                HAIFA construction
                Collision attack
                Preimage attack
                Birthday attack
                Side-channel attack
                Length extension attack
                CCM mode
                ChaCha20-Poly1305
                CWC mode
                EAX mode
                Galois/Counter Mode
                IAPM (mode)
                OCB mode
                CBC-MAC
                Data Authentication Algorithm
                HMAC
                One-key MAC
                PMAC (cryptography)
                Poly1305
                SipHash
                UMAC
                VMAC
                3-Way
                Akelarre (cipher)
                Anubis (cipher)
                BaseKing
                BassOmatic
                BATON
                BEAR and LION ciphers
                CAST-256
                Chiasmus (cipher)
                CIKS-1
                CIPHERUNICORN-A
                CIPHERUNICORN-E
                CLEFIA
                Cellular Message Encryption Algorithm
                Cobra ciphers
                COCONUT98
                Crab (cipher)
                Cryptomeria cipher
                CRYPTON
                CS-Cipher
                DEAL
                DES-X
                DFC (cipher)
                E2 (cipher)
                FEAL
                FEA-M
                FROG
                GDES
                Grand Cru (cipher)
                Hasty Pudding cipher
                Hierocrypt
                ICE (cipher)
                IDEA NXT
                Intel Cascade Cipher
                Iraqi block cipher
                Kalyna (cipher)
                KASUMI
                KeeLoq
                KHAZAD
                Khufu and Khafre
                KN-Cipher
                Kuznyechik
                Ladder-DES
                LOKI97
                LOKI
                Lucifer (cipher)
                M6 (cipher)
                M8 (cipher)
                MacGuffin (cipher)
                Madryga
                MAGENTA
                MARS (cipher)
                Mercy (cipher)
                MESH (cipher)
                MISTY1
                MMB (cipher)
                MULTI2
                MultiSwap
                New Data Seal
                NewDES
                Nimbus (cipher)
                NOEKEON
                NUSH
                PRESENT
                Prince (cipher)
                Q (cipher)
                REDOC
                Red Pike (cipher)
                S-1 block cipher
                SAFER
                SAVILLE
                SC2000
                SHACAL
                SHARK
                Simon (cipher)
                SM4 (cipher)
                Speck (cipher)
                Spectr-H64
                Square (cipher)
                SXAL/MBAL
                Threefish
                Treyfer
                UES (cipher)
                Xmx
                Zodiac (cipher)
                3-subset meet-in-the-middle attack
                Acoustic cryptanalysis
                Advanced Encryption Standard process
                Avalanche effect
                Biclique attack
                Black-bag cryptanalysis
                Block cipher mode of operation
                Block size (cryptography)
                Boomerang attack
                Chi-squared test
                Confusion and diffusion
                Davies attack
                Differential cryptanalysis
                Differential fault analysis
                Differential-linear attack
                Distinguishing attack
                EFF DES cracker
                Electromagnetic attack
                Feistel cipher
                Higher-order differential cryptanalysis
                Impossible differential cryptanalysis
                Initialization vector
                Integral cryptanalysis
                Interpolation attack
                Kendall rank correlation coefficient
                Key whitening
                Known-key distinguishing attack
                Lai–Massey scheme
                Linear cryptanalysis
                Meet-in-the-middle attack
                Mod n cryptanalysis
                Padding (cryptography)
                Partitioning cryptanalysis
                Permutation box
                Piling-up lemma
                Power analysis
                Product cipher
                Rebound attack
                Related-key attack
                Rotational cryptanalysis
                Rubber-hose cryptanalysis
                S-box
                Slide attack
                Substitution–permutation network
                Time/memory/data tradeoff attack
                Timing attack
                Truncated differential cryptanalysis
                Weak key
                Whitening transformation
                XSL attack
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
                ZHLS-GF
                Synchronized Multimedia Integration Language
                MathML""");

    }

    private void addArticles(String articles) {
        new BufferedReader(new StringReader(articles)).lines().forEach(this::addArticle);
    }


    private void addArticle(String title) {
        articles.add(new WikipediaArticle(title, "Unclassified"));
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

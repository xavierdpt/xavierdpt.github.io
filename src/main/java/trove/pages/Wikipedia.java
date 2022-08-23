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
        String cryptoRough = "Crypto / pre-classification";


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

        addArticle("Vigenère cipher", cryptoRough);
        addArticle("Caesar cipher", cryptoRough);
        addArticle("Frequency analysis", cryptoRough);
        addArticle("Kasiski examination", cryptoRough);
        addArticle("Cryptography", cryptoRough);
        addArticle("Hash-based cryptography", cryptoRough);
        addArticle("Non-commutative cryptography", cryptoRough);
        addArticle("RSA problem", cryptoRough);
        addArticle("IEEE P1363", cryptoRough);
        addArticle("NSA Suite B Cryptography", cryptoRough);
        addArticle("NIST Post-Quantum Cryptography Standardization", cryptoRough);
        addArticle("Algebraic Eraser", cryptoRough);
        addArticle("Efficient Probabilistic Public-Key Encryption Scheme", cryptoRough);
        addArticle("Hidden Field Equations", cryptoRough);
        addArticle("Lamport signature", cryptoRough);
        addArticle("McEliece cryptosystem", cryptoRough);
        addArticle("Merkle–Hellman knapsack cryptosystem", cryptoRough);
        addArticle("Naccache–Stern knapsack cryptosystem", cryptoRough);
        addArticle("XTR", cryptoRough);
        addArticle("Lattice-based cryptography", cryptoRough);
        addArticle("Learning with errors", cryptoRough);
        addArticle("Short integer solution problem", cryptoRough);
        addArticle("NTRUEncrypt", cryptoRough);
        addArticle("NTRUSign", cryptoRough);
        addArticle("Ring learning with errors key exchange", cryptoRough);
        addArticle("Ring learning with errors signature", cryptoRough);
        addArticle("BLISS signature scheme", cryptoRough);
        addArticle("NewHope", cryptoRough);
        addArticle("Discrete logarithm", cryptoRough);
        addArticle("Cramer–Shoup cryptosystem", cryptoRough);
        addArticle("Elliptic-curve Diffie–Hellman", cryptoRough);
        addArticle("Curve25519", cryptoRough);
        addArticle("Curve448", cryptoRough);
        addArticle("Elliptic Curve Digital Signature Algorithm", cryptoRough);
        addArticle("EdDSA", cryptoRough);
        addArticle("Encrypted key exchange", cryptoRough);
        addArticle("ElGamal encryption", cryptoRough);
        addArticle("ElGamal signature scheme", cryptoRough);
        addArticle("Schnorr signature", cryptoRough);
        addArticle("SPEKE", cryptoRough);
        addArticle("Secure Remote Password protocol", cryptoRough);
        addArticle("Station-to-Station protocol", cryptoRough);
        addArticle("Integer factorization", cryptoRough);
        addArticle("Blum–Goldwasser cryptosystem", cryptoRough);
        addArticle("Cayley–Purser algorithm", cryptoRough);
        addArticle("Damgård–Jurik cryptosystem", cryptoRough);
        addArticle("GMR (cryptography)", cryptoRough);
        addArticle("Goldwasser–Micali cryptosystem", cryptoRough);
        addArticle("Naccache–Stern cryptosystem", cryptoRough);
        addArticle("Rabin cryptosystem", cryptoRough);
        addArticle("RSA (cryptosystem)", cryptoRough);
        addArticle("Okamoto–Uchiyama cryptosystem", cryptoRough);
        addArticle("Schmidt-Samoa cryptosystem", cryptoRough);
        addArticle("Public-key cryptography", cryptoRough);
        addArticle("Optimal asymmetric encryption padding", cryptoRough);
        addArticle("Public key fingerprint", cryptoRough);
        addArticle("Web of trust", cryptoRough);
        addArticle("Key size", cryptoRough);
        addArticle("Identity-based cryptography", cryptoRough);
        addArticle("OpenPGP card", cryptoRough);
        addArticle("History of cryptography", cryptoRough);
        addArticle("Outline of cryptography", cryptoRough);
        addArticle("Cryptographic protocol", cryptoRough);
        addArticle("Authentication protocol", cryptoRough);
        addArticle("Cryptographic primitive", cryptoRough);
        addArticle("Cryptanalysis", cryptoRough);
        addArticle("Cryptocurrency", cryptoRough);
        addArticle("Cryptosystem", cryptoRough);
        addArticle("Cryptographic nonce", cryptoRough);
        addArticle("Cryptovirology", cryptoRough);
        addArticle("Hash function", cryptoRough);
        addArticle("Key derivation function", cryptoRough);
        addArticle("Digital signature", cryptoRough);
        addArticle("Kleptography", cryptoRough);
        addArticle("Key (cryptography)", cryptoRough);
        addArticle("Key exchange", cryptoRough);
        addArticle("Key generator", cryptoRough);
        addArticle("Key schedule", cryptoRough);
        addArticle("Key stretching", cryptoRough);
        addArticle("Keygen", cryptoRough);
        addArticle("Cryptojacking", cryptoRough);
        addArticle("Ransomware", cryptoRough);
        addArticle("Random number generation", cryptoRough);
        addArticle("Pseudorandom noise", cryptoRough);
        addArticle("Secure channel", cryptoRough);
        addArticle("Subliminal channel", cryptoRough);
        addArticle("Encryption", cryptoRough);
        addArticle("End-to-end encryption", cryptoRough);
        addArticle("Information-theoretic security", cryptoRough);
        addArticle("Plaintext", cryptoRough);
        addArticle("Code (cryptography)", cryptoRough);
        addArticle("Ciphertext", cryptoRough);
        addArticle("Shared secret", cryptoRough);
        addArticle("Trapdoor function", cryptoRough);
        addArticle("Trusted timestamping", cryptoRough);
        addArticle("Key-based routing", cryptoRough);
        addArticle("Onion routing", cryptoRough);
        addArticle("Garlic routing", cryptoRough);
        addArticle("Kademlia", cryptoRough);
        addArticle("Mix network", cryptoRough);
        addArticle("Cryptographic hash function", cryptoRough);
        addArticle("Block cipher", cryptoRough);
        addArticle("Stream cipher", cryptoRough);
        addArticle("Symmetric-key algorithm", cryptoRough);
        addArticle("Authenticated encryption", cryptoRough);
        addArticle("Quantum key distribution", cryptoRough);
        addArticle("Quantum cryptography", cryptoRough);
        addArticle("Post-quantum cryptography", cryptoRough);
        addArticle("Message authentication code", cryptoRough);
        addArticle("Cryptographically secure pseudorandom number generator", cryptoRough);
        addArticle("Steganography", cryptoRough);
        addArticle("Hash function security summary", cryptoRough);
        addArticle("MD5", cryptoRough);
        addArticle("SHA-1", cryptoRough);
        addArticle("SHA-2", cryptoRough);
        addArticle("SHA-3", cryptoRough);
        addArticle("BLAKE (hash function)", cryptoRough);
        addArticle("Grøstl", cryptoRough);
        addArticle("JH (hash function)", cryptoRough);
        addArticle("Skein (hash function)", cryptoRough);
        addArticle("CubeHash", cryptoRough);
        addArticle("Elliptic curve only hash", cryptoRough);
        addArticle("Fast syndrome-based hash", cryptoRough);
        addArticle("GOST (hash function)", cryptoRough);
        addArticle("HAS-160", cryptoRough);
        addArticle("HAVAL", cryptoRough);
        addArticle("Kupyna", cryptoRough);
        addArticle("LSH (hash function)", cryptoRough);
        addArticle("MASH-1", cryptoRough);
        addArticle("MD2 (hash function)", cryptoRough);
        addArticle("MD4", cryptoRough);
        addArticle("MD6", cryptoRough);
        addArticle("MDC-2", cryptoRough);
        addArticle("N-hash", cryptoRough);
        addArticle("RIPEMD", cryptoRough);
        addArticle("RadioGatún", cryptoRough);
        addArticle("SM3 (hash function)", cryptoRough);
        addArticle("SWIFFT", cryptoRough);
        addArticle("Snefru", cryptoRough);
        addArticle("Streebog", cryptoRough);
        addArticle("Tiger (hash function)", cryptoRough);
        addArticle("Very smooth hash", cryptoRough);
        addArticle("Whirlpool (hash function)", cryptoRough);
        addArticle("Argon2", cryptoRough);
        addArticle("Balloon hashing", cryptoRough);
        addArticle("bcrypt", cryptoRough);
        addArticle("Password Hashing Competition", cryptoRough);
        addArticle("crypt (C)", cryptoRough);
        addArticle("LAN Manager", cryptoRough);
        addArticle("Lyra2", cryptoRough);
        addArticle("PBKDF2", cryptoRough);
        addArticle("scrypt", cryptoRough);
        addArticle("HKDF", cryptoRough);
        addArticle("ARIA (cipher)", cryptoRough);
        addArticle("Camellia (cipher)", cryptoRough);
        addArticle("CAST-128", cryptoRough);
        addArticle("GOST (block cipher)", cryptoRough);
        addArticle("International Data Encryption Algorithm", cryptoRough);
        addArticle("LEA (cipher)", cryptoRough);

        addArticle("SEED", cryptoRough);
        addArticle("Skipjack (cipher)", cryptoRough);


        addArticle("Advanced Encryption Standard", cryptoRough);
        addArticle("Blowfish (cipher)", cryptoRough);
        addArticle("Data Encryption Standard", cryptoRough);
        addArticle("DES supplementary material", cryptoRough);
        addArticle("Triple DES", cryptoRough);
        addArticle("Serpent (cipher)", cryptoRough);
        addArticle("Twofish", cryptoRough);
        addArticle("CRYPTREC", cryptoRough);
        addArticle("NESSIE", cryptoRough);
        addArticle("NIST hash function competition", cryptoRough);
        addArticle("Merkle tree", cryptoRough);
        addArticle("Message authentication", cryptoRough);
        addArticle("Proof of work", cryptoRough);
        addArticle("Salt (cryptography)", cryptoRough);
        addArticle("Pepper (cryptography)", cryptoRough);
        addArticle("Hash collision", cryptoRough);
        addArticle("Merkle–Damgård construction", cryptoRough);
        addArticle("Sponge function", cryptoRough);
        addArticle("HAIFA construction", cryptoRough);
        addArticle("Collision attack", cryptoRough);
        addArticle("Preimage attack", cryptoRough);
        addArticle("Birthday attack", cryptoRough);
        addArticle("Rainbow table", cryptoRough);
        addArticle("Side-channel attack", cryptoRough);
        addArticle("Length extension attack", cryptoRough);
        addArticle("CCM mode", cryptoRough);
        addArticle("ChaCha20-Poly1305", cryptoRough);
        addArticle("CWC mode", cryptoRough);
        addArticle("EAX mode", cryptoRough);
        addArticle("Galois/Counter Mode", cryptoRough);
        addArticle("IAPM (mode)", cryptoRough);
        addArticle("OCB mode", cryptoRough);
        addArticle("CBC-MAC", cryptoRough);
        addArticle("Data Authentication Algorithm", cryptoRough);
        addArticle("HMAC", cryptoRough);
        addArticle("One-key MAC", cryptoRough);
        addArticle("PMAC (cryptography)", cryptoRough);
        addArticle("Poly1305", cryptoRough);
        addArticle("SipHash", cryptoRough);
        addArticle("UMAC", cryptoRough);
        addArticle("VMAC", cryptoRough);
        addArticle("3-Way", cryptoRough);
        addArticle("Akelarre (cipher)", cryptoRough);
        addArticle("Anubis (cipher)", cryptoRough);
        addArticle("BaseKing", cryptoRough);
        addArticle("BassOmatic", cryptoRough);
        addArticle("BATON", cryptoRough);
        addArticle("BEAR and LION ciphers", cryptoRough);
        addArticle("CAST-256", cryptoRough);
        addArticle("Chiasmus (cipher)", cryptoRough);
        addArticle("CIKS-1", cryptoRough);
        addArticle("CIPHERUNICORN-A", cryptoRough);
        addArticle("CIPHERUNICORN-E", cryptoRough);
        addArticle("CLEFIA", cryptoRough);
        addArticle("Cellular Message Encryption Algorithm", cryptoRough);
        addArticle("Cobra ciphers", cryptoRough);
        addArticle("COCONUT98", cryptoRough);
        addArticle("Crab (cipher)", cryptoRough);
        addArticle("Cryptomeria cipher", cryptoRough);
        addArticle("CRYPTON", cryptoRough);
        addArticle("CS-Cipher", cryptoRough);
        addArticle("DEAL", cryptoRough);
        addArticle("DES-X", cryptoRough);
        addArticle("DFC (cipher)", cryptoRough);
        addArticle("E2 (cipher)", cryptoRough);
        addArticle("FEAL", cryptoRough);
        addArticle("FEA-M", cryptoRough);
        addArticle("FROG", cryptoRough);
        addArticle("GDES", cryptoRough);
        addArticle("Grand Cru (cipher)", cryptoRough);
        addArticle("Hasty Pudding cipher", cryptoRough);
        addArticle("Hierocrypt", cryptoRough);
        addArticle("ICE (cipher)", cryptoRough);
        addArticle("IDEA NXT", cryptoRough);
        addArticle("Intel Cascade Cipher", cryptoRough);
        addArticle("Iraqi block cipher", cryptoRough);
        addArticle("Kalyna (cipher)", cryptoRough);
        addArticle("KASUMI", cryptoRough);
        addArticle("KeeLoq", cryptoRough);
        addArticle("KHAZAD", cryptoRough);
        addArticle("Khufu and Khafre", cryptoRough);
        addArticle("KN-Cipher", cryptoRough);
        addArticle("Kuznyechik", cryptoRough);
        addArticle("Ladder-DES", cryptoRough);
        addArticle("LOKI97", cryptoRough);
        addArticle("LOKI", cryptoRough);
        addArticle("Lucifer (cipher)", cryptoRough);
        addArticle("M6 (cipher)", cryptoRough);
        addArticle("M8 (cipher)", cryptoRough);
        addArticle("MacGuffin (cipher)", cryptoRough);
        addArticle("Madryga", cryptoRough);
        addArticle("MAGENTA", cryptoRough);
        addArticle("MARS (cipher)", cryptoRough);
        addArticle("Mercy (cipher)", cryptoRough);
        addArticle("MESH (cipher)", cryptoRough);
        addArticle("MISTY1", cryptoRough);
        addArticle("MMB (cipher)", cryptoRough);
        addArticle("MULTI2", cryptoRough);
        addArticle("MultiSwap", cryptoRough);
        addArticle("New Data Seal", cryptoRough);
        addArticle("NewDES", cryptoRough);
        addArticle("Nimbus (cipher)", cryptoRough);
        addArticle("NOEKEON", cryptoRough);
        addArticle("NUSH", cryptoRough);
        addArticle("PRESENT", cryptoRough);
        addArticle("Prince (cipher)", cryptoRough);
        addArticle("Q (cipher)", cryptoRough);
        addArticle("REDOC", cryptoRough);
        addArticle("Red Pike (cipher)", cryptoRough);
        addArticle("S-1 block cipher", cryptoRough);
        addArticle("SAFER", cryptoRough);
        addArticle("SAVILLE", cryptoRough);
        addArticle("SC2000", cryptoRough);
        addArticle("SHACAL", cryptoRough);
        addArticle("SHARK", cryptoRough);
        addArticle("Simon (cipher)", cryptoRough);
        addArticle("SM4 (cipher)", cryptoRough);
        addArticle("Speck (cipher)", cryptoRough);
        addArticle("Spectr-H64", cryptoRough);
        addArticle("Square (cipher)", cryptoRough);
        addArticle("SXAL/MBAL", cryptoRough);
        addArticle("Threefish", cryptoRough);
        addArticle("Treyfer", cryptoRough);
        addArticle("UES (cipher)", cryptoRough);
        addArticle("Xmx", cryptoRough);

        addArticle("Zodiac (cipher)", cryptoRough);
        addArticle("3-subset meet-in-the-middle attack", cryptoRough);
        addArticle("Acoustic cryptanalysis", cryptoRough);
        addArticle("Advanced Encryption Standard process", cryptoRough);
        addArticle("Avalanche effect", cryptoRough);
        addArticle("Biclique attack", cryptoRough);
        addArticle("Black-bag cryptanalysis", cryptoRough);
        addArticle("Block cipher mode of operation", cryptoRough);
        addArticle("Block size (cryptography)", cryptoRough);
        addArticle("Boomerang attack", cryptoRough);
        addArticle("Brute-force attack", cryptoRough);
        addArticle("Chi-squared test", cryptoRough);
        addArticle("Confusion and diffusion", cryptoRough);
        addArticle("Davies attack", cryptoRough);
        addArticle("Differential cryptanalysis", cryptoRough);
        addArticle("Differential fault analysis", cryptoRough);
        addArticle("Differential-linear attack", cryptoRough);
        addArticle("Distinguishing attack", cryptoRough);
        addArticle("EFF DES cracker", cryptoRough);
        addArticle("Electromagnetic attack", cryptoRough);
        addArticle("Feistel cipher", cryptoRough);
        addArticle("Higher-order differential cryptanalysis", cryptoRough);
        addArticle("Impossible differential cryptanalysis", cryptoRough);
        addArticle("Initialization vector", cryptoRough);
        addArticle("Integral cryptanalysis", cryptoRough);
        addArticle("Interpolation attack", cryptoRough);
        addArticle("Kendall rank correlation coefficient", cryptoRough);
        addArticle("Key whitening", cryptoRough);
        addArticle("Known-key distinguishing attack", cryptoRough);
        addArticle("Lai–Massey scheme", cryptoRough);
        addArticle("Linear cryptanalysis", cryptoRough);
        addArticle("Meet-in-the-middle attack", cryptoRough);
        addArticle("Mod n cryptanalysis", cryptoRough);
        addArticle("Padding (cryptography)", cryptoRough);
        addArticle("Partitioning cryptanalysis", cryptoRough);
        addArticle("Permutation box", cryptoRough);
        addArticle("Piling-up lemma", cryptoRough);
        addArticle("Power analysis", cryptoRough);
        addArticle("Product cipher", cryptoRough);
        addArticle("Rebound attack", cryptoRough);
        addArticle("Related-key attack", cryptoRough);
        addArticle("Rotational cryptanalysis", cryptoRough);
        addArticle("Rubber-hose cryptanalysis", cryptoRough);
        addArticle("S-box", cryptoRough);
        addArticle("Slide attack", cryptoRough);
        addArticle("Substitution–permutation network", cryptoRough);
        addArticle("Time/memory/data tradeoff attack", cryptoRough);
        addArticle("Timing attack", cryptoRough);
        addArticle("Truncated differential cryptanalysis", cryptoRough);
        addArticle("Weak key", cryptoRough);
        addArticle("Whitening transformation", cryptoRough);
        addArticle("XSL attack", cryptoRough);
        addArticles(cryptoRough, """
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
                Extensible Authentication Protocol
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
                HTTPS
                Pretty Good Privacy
                Sender ID
                Sender Policy Framework
                S/MIME
                Secure Shell
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
                """);

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

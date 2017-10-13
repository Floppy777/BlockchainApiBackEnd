package com.indo.blockchain.json;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WalletJson implements Serializable{

	private String version;
	
	private String id;
	
	private String address;
	
	private Crypto crypto;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Crypto getCrypto() {
		return crypto;
	}

	public void setCrypto(Crypto crypto) {
		this.crypto = crypto;
	}

	public class Crypto implements Serializable{
		
		private String ciphertext;
		
		private String cipher;
		
		private String kdf;
		
		private CipherParam cipherparams; 
		
		private KdfParams kdfparams;
		
		private String mac;
		
		public String getCiphertext() {
			return ciphertext;
		}

		public void setCiphertext(String cyphertext) {
			this.ciphertext = cyphertext;
		}

		public String getCipher() {
			return cipher;
		}

		public void setCipher(String cipher) {
			this.cipher = cipher;
		}

		public String getKdf() {
			return kdf;
		}

		public void setKdf(String kdf) {
			this.kdf = kdf;
		}

		public CipherParam getCipherparams() {
			return cipherparams;
		}

		public void setCipherparams(CipherParam cipherparams) {
			this.cipherparams = cipherparams;
		}

		public KdfParams getKdfparams() {
			return kdfparams;
		}

		public void setKdfparams(KdfParams kdfparams) {
			this.kdfparams = kdfparams;
		}
		
		public String getMac(){
			return mac;
		}
		
		public void setMac(String mac){
			this.mac = mac;
		}

		public class CipherParam implements Serializable{
			
			private String iv;

			public String getIv() {
				return iv;
			}

			public void setIv(String iv) {
				this.iv = iv;
			}

			@Override
			public String toString() {
				return "{ iv=" + iv + "}";
			}
		}
		
		public class KdfParams implements Serializable{
			
			private int dklen;
			
			private String salt;
			
			private int n;
			
			private int r;
			
			private int p;

			public int getDklen() {
				return dklen;
			}

			public void setDklen(int dklen) {
				this.dklen = dklen;
			}

			public String getSalt() {
				return salt;
			}

			public void setSalt(String salt) {
				this.salt = salt;
			}

			public int getN() {
				return n;
			}

			public void setN(int n) {
				this.n = n;
			}

			public int getR() {
				return r;
			}

			public void setR(int r) {
				this.r = r;
			}

			public int getP() {
				return p;
			}

			public void setP(int p) {
				this.p = p;
			}

			@Override
			public String toString() {
				return "{ dklen=" + dklen + ", salt=" + salt + ", n=" + n + ", r=" + r + ", p=" + p + "}";
			}
		}

		@Override
		public String toString() {
			return "{ ciphertext=" + ciphertext + ", cipher=" + cipher + ", kdf=" + kdf + ", cipherparams="
					+ cipherparams + ", kdfparams=" + kdfparams + ", mac=" + mac + "}";
		}
	}

	@Override
	public String toString() {
		return "{ version=" + version + ", id=" + id + ", address=" + address + ", crypto=" + crypto.toString() + "}";
	}
}
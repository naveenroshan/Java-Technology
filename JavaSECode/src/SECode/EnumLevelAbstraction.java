package SECode;

public enum EnumLevelAbstraction {
	//Enum Abstract Methods
		
		ONE
		{
	        public String asLowerCase() {
	            return ONE.toString().toLowerCase();
	        }
		},
		TWO
		{
			public String asLowerCase() {
	            return MEDIUM.toString().toLowerCase();
	        }
		},
		THREE
		{
			public String asLowerCase() {
	            return THREE.toString().toLowerCase();
	        }
		},

		public abstract String asLowerCase();	
	}

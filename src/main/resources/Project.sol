contract Project { 
    
    address _owner; 
    address _company;
    
    uint public _amountWanted; 
    uint public _amountTotal; 
    uint public _duration; 
    uint public _nbDonationTotal; 
    
    struct Donation { 
        uint nbDonation; 
        uint amount; 
    } 
    
    mapping(address => Donation) public Amounts; 
    uint MAX_DEPOSIT = 100; 
    uint MIN_DEPOSIT = 1;

    // Active : On peut donner des ether 
    // Reached : On peut récuprer des ether. La somme est atteinte 
    // Inactive : On peut rien faire lol 
    enum State { NotEnabled,Active, Reached, Inactive } 
    State _state; 

    //Constructeur du smart contract 
    function Project(uint duration, uint amountWanted) public { 
        if(amountWanted > MAX_DEPOSIT){ 
            revert(); 
        } 
        _nbDonationTotal += 1; 
        _amountTotal = 0; 
        _duration = duration * 1 days; 
        _amountWanted = amountWanted; 
        _owner = msg.sender; 
        _state = State.NotEnabled; 
    } 
    
    // Permet de rendre le smart contract "Reached"
    function projectReached() public onlyOwner {
    	if(_state == State.Active){
    		_state = State.Reached;
    	}
    }
    
    function enableProject() public onlyOwner {
    	if(_state == State.NotEnabled){
    		_state = State.Active;
    	}
    }
    
    // Permet d'effectuer une donation 
    function depositMoneyToSmartContract() public payable { 
        if(_state == State.Active){ 
            _amountTotal += msg.value; 
            _nbDonationTotal += 1; 
            Amounts[msg.sender].nbDonation +=1; 
            Amounts[msg.sender].amount += msg.value; 
        
            if(_amountWanted >= msg.value){ 
                _state = State.Reached; 
            } 
        } 
    } 
    
    // demande de paiement 
    function askForPayment(uint value) onlyOwner ifTotalWantedReached public { 
        _amountTotal -= value; 
        _owner.transfer(value); 
    } 
    
    function desactiveContract() public onlyOwner{ 
        _state = State.Inactive; 
    } 
    
    function kill() public onlyOwner payable { 
        _owner.transfer(_amountTotal); 
        selfdestruct(_owner); 
    } 
    
    // Getter 
    function getDuration() public constant returns(uint duration){ 
        return _duration; 
    } 
    
    function getAmount() public constant returns(uint amoutTotal){ 
        return _amountTotal; 
    } 
    
    function getAmountWanted() public constant returns(uint amountWanted){ 
        return _amountWanted; 
    } 
    
    function getNbDonationTotal() public constant returns(uint nbDonationTotal){ 
        return _nbDonationTotal; 
    } 
    
    function getState() public constant returns(State state){ 
        return _state; 
    } 
    
    function getNbDonation() public constant returns(uint nbDonation){ 
        return Amounts[msg.sender].nbDonation; 
    } 
    
    function getAmountDonation() public constant  returns(uint amount){ 
        return Amounts[msg.sender].amount; 
    } 
    
    // Modifier owner. Seul le propriétaire du SC peut interragir avec la fonction 
    modifier onlyOwner() { 
        require(msg.sender == _owner) ; 
        _; 
    } 
    
    // Modifier ether. La transaction est valide seulement si elle contient des ethers 
    modifier transactionMustContainEther() { 
        require(msg.value == 0); 
        _; 
    } 
    
    // 
    modifier ifTotalWantedReached(){ 
        require(_state == State.Reached && _amountTotal >= _amountWanted) ; 
        _; 
    } 
} 

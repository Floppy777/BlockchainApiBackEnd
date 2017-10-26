package com.indo.blockchain.ethereum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.1.
 */
public final class ProjectSmartContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160408061045e8339810160405280805191906020018051600580546001019055600060038190556201518090940260045560025550508054600160a060020a033316600160a060020a03199091161790556103ec806100726000396000f300606060405236156100e35763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663245c7c6081146100e857806336c483fc1461010d5780633e11fe791461012057806341c0e1b51461015757806358e472711461016157806370eac62e146101775780638a5294991461018a578063a38beb241461019d578063a4e2a16e146101a5578063ad2e8c9b146101d4578063b2bdfa7b146101e7578063d321fe29146101fa578063dada4e0a1461020d578063e245daf214610220578063e2ef414914610233578063f7b6f65014610246575b600080fd5b34156100f357600080fd5b6100fb610259565b60405190815260200160405180910390f35b341561011857600080fd5b6100fb61025f565b341561012b57600080fd5b61013f600160a060020a0360043516610265565b60405191825260208201526040908101905180910390f35b61015f61027e565b005b341561016c57600080fd5b61015f6004356102c5565b341561018257600080fd5b6100fb610304565b341561019557600080fd5b6100fb610323565b61015f610329565b34156101b057600080fd5b6101b8610368565b604051600160a060020a03909116815260200160405180910390f35b34156101df57600080fd5b6100fb610377565b34156101f257600080fd5b6101b861037d565b341561020557600080fd5b6100fb61038c565b341561021857600080fd5b6100fb610392565b341561022b57600080fd5b6100fb610398565b341561023e57600080fd5b6100fb61039e565b341561025157600080fd5b6100fb6103a4565b60045481565b60035481565b6006602052600090815260409020805460019091015482565b600054600354600160a060020a039091169080156108fc0290604051600060405180830381858888f1935050505015156102b757600080fd5b600054600160a060020a0316ff5b600380548290039055600054600160a060020a031681156108fc0282604051600060405180830381858888f19350505050151561030157600080fd5b50565b600160a060020a03331660009081526006602052604090206001015490565b60025490565b6003805434908101909155600580546001908101909155600160a060020a03331660009081526006602052604090208054820181550180549091019055565b600154600160a060020a031681565b60045490565b600054600160a060020a031681565b60035490565b60025481565b60055490565b60055481565b600160a060020a033316600090815260066020526040902054905600a165627a7a72305820f1b8a526f57ac2d3a2c4c77dc7250b6341df499df0e493b9d4ab5f749d8c79300029";

    private ProjectSmartContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private ProjectSmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<Uint256> _duration() {
        Function function = new Function("_duration", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _amountTotal() {
        Function function = new Function("_amountTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> Amounts(Address param0) {
        Function function = new Function("Amounts", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> kill(BigInteger weiValue) {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function, weiValue);
    }

    public Future<TransactionReceipt> askForPayment(Uint256 value) {
        Function function = new Function("askForPayment", Arrays.<Type>asList(value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getAmountDonation() {
        Function function = new Function("getAmountDonation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getAmountWanted() {
        Function function = new Function("getAmountWanted", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> depositMoneyToSmartContract(BigInteger weiValue) {
        Function function = new Function("depositMoneyToSmartContract", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function, weiValue);
    }

    public Future<Address> _company() {
        Function function = new Function("_company", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getDuration() {
        Function function = new Function("getDuration", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Address> _owner() {
        Function function = new Function("_owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getAmount() {
        Function function = new Function("getAmount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _amountWanted() {
        Function function = new Function("_amountWanted", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getNbDonationTotal() {
        Function function = new Function("getNbDonationTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _nbDonationTotal() {
        Function function = new Function("_nbDonationTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getNbDonation() {
        Function function = new Function("getNbDonation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<ProjectSmartContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 duration, Uint256 amountWanted) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(duration, amountWanted));
        return deployAsync(ProjectSmartContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<ProjectSmartContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 duration, Uint256 amountWanted) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(duration, amountWanted));
        return deployAsync(ProjectSmartContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static ProjectSmartContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectSmartContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ProjectSmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectSmartContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
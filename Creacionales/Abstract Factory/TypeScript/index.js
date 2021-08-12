var ConcreteFactory1 = /** @class */ (function () {
    function ConcreteFactory1() {
    }
    ConcreteFactory1.prototype.createProductA = function () {
        return new ConcreteProductA1();
    };
    ConcreteFactory1.prototype.createProductB = function () {
        return new ConcreteProductB1();
    };
    return ConcreteFactory1;
}());
var ConcreteFactory2 = /** @class */ (function () {
    function ConcreteFactory2() {
    }
    ConcreteFactory2.prototype.createProductA = function () {
        return new ConcreteProductA2();
    };
    ConcreteFactory2.prototype.createProductB = function () {
        return new ConcreteProductB2();
    };
    return ConcreteFactory2;
}());
var ConcreteProductA1 = /** @class */ (function () {
    function ConcreteProductA1() {
    }
    ConcreteProductA1.prototype.usefulFunctionA = function () {
        return 'The result of the product A1.';
    };
    return ConcreteProductA1;
}());
var ConcreteProductA2 = /** @class */ (function () {
    function ConcreteProductA2() {
    }
    ConcreteProductA2.prototype.usefulFunctionA = function () {
        return 'The result of the product A2.';
    };
    return ConcreteProductA2;
}());
var ConcreteProductB1 = /** @class */ (function () {
    function ConcreteProductB1() {
    }
    ConcreteProductB1.prototype.usefulFunctionB = function () {
        return 'The result of the product B1.';
    };
    ConcreteProductB1.prototype.anotherUsefulFunctionB = function (collaborator) {
        var result = collaborator.usefulFunctionA();
        return "The result of the B1 collaborating with the (" + result + ")";
    };
    return ConcreteProductB1;
}());
var ConcreteProductB2 = /** @class */ (function () {
    function ConcreteProductB2() {
    }
    ConcreteProductB2.prototype.usefulFunctionB = function () {
        return 'The result of the product B2.';
    };
    ConcreteProductB2.prototype.anotherUsefulFunctionB = function (collaborator) {
        var result = collaborator.usefulFunctionA();
        return "The result of the B2 collaborating with the (" + result + ")";
    };
    return ConcreteProductB2;
}());
var clientCode = function (factory) {
    var productA = factory.createProductA();
    var productB = factory.createProductB();
    console.log(productB.usefulFunctionB());
    console.log(productB.anotherUsefulFunctionB(productA));
};
console.log('Client: Testing client code with the first factory type...');
clientCode(new ConcreteFactory1());
console.log('');
console.log('Client: Testing the same client code with the second factory type..');
clientCode(new ConcreteFactory2());

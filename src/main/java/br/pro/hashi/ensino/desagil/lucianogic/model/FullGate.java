package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorGate1;
	private XorGate xorGate2;
	private AndGate andGate1;
	private AndGate andGate2;
	private OrGate orGate;

	public FullGate() {
		super(3, 2);

		name = "FULL";
		
		xorGate1 = new XorGate();
		xorGate2 = new XorGate();
		andGate1 = new AndGate();
		andGate2 = new AndGate();
		orGate = new OrGate();
		
		xorGate2.connect(xorGate1, 0);
		
		andGate1.connect(xorGate1, 0);
		
		orGate.connect(andGate1, 0);
		orGate.connect(andGate2, 1);
		
		
	}

	@Override
	public boolean doRead(int index) {
		if (index == 0 ){
			return xorGate2.read();
		}
		else {
			return orGate.read();
		}
		
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			xorGate1.connect(emitter, 0);
			andGate2.connect(emitter, 0);
			break;
		case 1:
			xorGate1.connect(emitter, 1);
			andGate2.connect(emitter, 1);
			break;
		case 2:
			xorGate2.connect(emitter, 1);
			andGate1.connect(emitter, 1);	
		}
	
	}
}

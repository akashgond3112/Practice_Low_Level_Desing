package com.lld.design.atm;

import com.lld.design.card.CardReader;
import com.lld.design.cash.CashDispenser;
import com.lld.design.deposit.DepositSlot;

public class ATM {

    private Double totalAmountRemaining;
    private Location location;
    private Long atmId;
    private Screen screen;
    private DepositSlot cashDepositSlot;
    private DepositSlot checkDepositSlot;
    private Printer printer;
    private CashDispenser cashDispenser;
    private CardReader cardReader;

    public ATM(Double totalAmountRemaining, Location location, Long atmId,
               Screen screen, DepositSlot cashDepositSlot, DepositSlot checkDepositSlot,
               Printer printer, CashDispenser cashDispenser, CardReader cardReader) {
        this.totalAmountRemaining = totalAmountRemaining;
        this.location = location;
        this.atmId = atmId;
        this.screen = screen;
        this.cashDepositSlot = cashDepositSlot;
        this.checkDepositSlot = checkDepositSlot;
        this.printer = printer;
        this.cashDispenser = cashDispenser;
        this.cardReader = cardReader;
    }

    public Double debit(Double amount) {
        totalAmountRemaining -= amount;
        return amount;
    }

    public Double getTotalAmountRemaining() {
        return totalAmountRemaining;
    }

    public void setTotalAmountRemaining(Double totalAmountRemaining) {
        this.totalAmountRemaining = totalAmountRemaining;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public DepositSlot getCashDepositSlot() {
        return cashDepositSlot;
    }

    public void setCashDepositSlot(DepositSlot cashDepositSlot) {
        this.cashDepositSlot = cashDepositSlot;
    }

    public DepositSlot getCheckDepositSlot() {
        return checkDepositSlot;
    }

    public void setCheckDepositSlot(DepositSlot checkDepositSlot) {
        this.checkDepositSlot = checkDepositSlot;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCashDispenser(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public void setCardReader(CardReader cardReader) {
        this.cardReader = cardReader;
    }

}

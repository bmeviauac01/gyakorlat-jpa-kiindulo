package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the INVOICE database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String cancelled;
	
	private LocalDate creationdate;

	private String customerocity;

	private String customeroname;

	private String customerostreet;

	private String customerozipcode;

	private LocalDate deliverydate;

	private LocalDate paymentdeadline;

	private String paymentmethod;

	private BigDecimal printedcopies;

	//bi-directional many-to-one association to Invoiceissuer
	@ManyToOne
	@JoinColumn(name="INVOICEISSUERID")
	private Invoiceissuer invoiceissuer;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDERID")
	private Order order;

	//bi-directional many-to-one association to Invoiceitem
	@OneToMany(mappedBy="invoice")
	private List<Invoiceitem> invoiceitems;

	public Invoice() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCancelled() {
		return this.cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

	public LocalDate getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(LocalDate creationdate) {
		this.creationdate = creationdate;
	}

	public String getCustomerocity() {
		return this.customerocity;
	}

	public void setCustomerocity(String customerocity) {
		this.customerocity = customerocity;
	}

	public String getCustomeroname() {
		return this.customeroname;
	}

	public void setCustomeroname(String customeroname) {
		this.customeroname = customeroname;
	}

	public String getCustomerostreet() {
		return this.customerostreet;
	}

	public void setCustomerostreet(String customerostreet) {
		this.customerostreet = customerostreet;
	}

	public String getCustomerozipcode() {
		return this.customerozipcode;
	}

	public void setCustomerozipcode(String customerozipcode) {
		this.customerozipcode = customerozipcode;
	}

	public LocalDate getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(LocalDate deliverydate) {
		this.deliverydate = deliverydate;
	}

	public LocalDate getPaymentdeadline() {
		return this.paymentdeadline;
	}

	public void setPaymentdeadline(LocalDate paymentdeadline) {
		this.paymentdeadline = paymentdeadline;
	}

	public String getPaymentmethod() {
		return this.paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public BigDecimal getPrintedcopies() {
		return this.printedcopies;
	}

	public void setPrintedcopies(BigDecimal printedcopies) {
		this.printedcopies = printedcopies;
	}

	public Invoiceissuer getInvoiceissuer() {
		return this.invoiceissuer;
	}

	public void setInvoiceissuer(Invoiceissuer invoiceissuer) {
		this.invoiceissuer = invoiceissuer;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Invoiceitem> getInvoiceitems() {
		return this.invoiceitems;
	}

	public void setInvoiceitems(List<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Invoiceitem addInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().add(invoiceitem);
		invoiceitem.setInvoice(this);

		return invoiceitem;
	}

	public Invoiceitem removeInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().remove(invoiceitem);
		invoiceitem.setInvoice(null);

		return invoiceitem;
	}

}
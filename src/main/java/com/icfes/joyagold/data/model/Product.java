package com.icfes.joyagold.data.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product")
public class Product {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id", nullable = false)
	private Integer id;

    @Column(name = "prod_name", nullable = false, length = 400)
	private String name;

    @Column(name = "prod_weight", nullable = false)
	private Integer weight;

    @Column(name = "prod_color", nullable = false, length = 50)
	private String color;

    @Column(name = "prod_price", nullable = false)
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_mat_id")
	private Material material;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_archetype_id")
	private Archetype archetype;

    @Temporal(value = TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "prod_date_creation", insertable = true, updatable = false)
	protected Date creationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "prod_date_update", insertable = true, updatable = true)
	protected Date updateDate;
}
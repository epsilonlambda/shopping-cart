import React from 'react';
import NumericInput from 'react-numeric-input';
import './qualityControl.css';

export default class QuantityControl extends React.Component {
    static propTypes = {
        onChange: React.PropTypes.func,
        value: React.PropTypes.number
    };
    
    render() {
        return (
            <div className="esc-quantity-control">
                <div className="esc-gen-label">Qty:</div>
                <NumericInput className="esc-gen-number" min={1} value={this.props.value} onChange={this.props.onChange} />
            </div>
        );
    }
}